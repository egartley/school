# Copyright 2013, Michael H. Goldwasser
#
# Developed for use with the book:
#
#        Data Structures and Algorithms in Python
#        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
#        John Wiley & Sons, 2013
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.    See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.    If not, see <http://www.gnu.org/licenses/>.

from collections import MutableMapping
from random import randrange


class MapBase(MutableMapping):
    """Our own abstract base class that includes a nonpublic _Item class."""

    #------------------------------- nested _Item class -------------------------------
    class _Item:
        """Lightweight composite to store key-value pairs as map items."""
        __slots__ = '_key', '_value'

        def __init__(self, k, v):
            self._key = k
            self._value = v

        def __eq__(self, other):                             
            return self._key == other._key     # compare items based on their keys

        def __ne__(self, other):
            return not (self == other)             # opposite of __eq__

        def __lt__(self, other):                             
            return self._key < other._key        # compare items based on their keys


class UnsortedTableMap(MapBase):
    """Map implementation using an unordered list."""

    def __init__(self):
        """Create an empty map."""
        self._table = []  # list of _Item's

    def __getitem__(self, k):
        """Return value associated with key k (raise KeyError if not found)."""
        for item in self._table:
            if k == item._key:
                return item._value
        raise KeyError('Key Error: ' + repr(k))

    def __setitem__(self, k, v):
        """Assign value v to key k, overwriting existing value if present."""
        for item in self._table:
            if k == item._key:  # Found a match:
                item._value = v  # reassign value
                return  # and quit
        # did not find match for key
        self._table.append(self._Item(k, v))

    def __delitem__(self, k):
        """Remove item associated with key k (raise KeyError if not found)."""
        for j in range(len(self._table)):
            if k == self._table[j]._key:  # Found a match:
                self._table.pop(j)  # remove item
                return  # and quit
        raise KeyError('Key Error: ' + repr(k))

    def __len__(self):
        """Return number of items in the map."""
        return len(self._table)

    def __iter__(self):
        """Generate iteration of the map's keys."""
        for item in self._table:
            yield item._key  # yield the KEY


class HashMapBase(MapBase):
    """Abstract base class for map using hash-table with MAD compression.

    Keys must be hashable and non-None.
    """

    def __init__(self, cap=11, p=109345121):
        """Create an empty hash-table map.

        cap         initial table size (default 11)
        p             positive prime used for MAD (default 109345121)
        """
        self._table = cap * [ None ]
        self._n = 0                                                                     # number of entries in the map
        self._prime = p                                                             # prime for MAD compression
        self._scale = 1 + randrange(p-1)                            # scale from 1 to p-1 for MAD
        self._shift = randrange(p)                                        # shift from 0 to p-1 for MAD

    def _hash_function(self, k):
        return (hash(k)*self._scale + self._shift) % self._prime % len(self._table)

    def __len__(self):
        return self._n

    def __getitem__(self, k):
        j = self._hash_function(k)
        return self._bucket_getitem(j, k)                         # may raise KeyError

    def __setitem__(self, k, v):
        j = self._hash_function(k)
        self._bucket_setitem(j, k, v)                                 # subroutine maintains self._n
        #if self._n > len(self._table) // 2:                     # keep load factor <= 0.5
            #self._resize(2 * len(self._table) - 1)            # number 2^x - 1 is often prime

    def __delitem__(self, k):
        j = self._hash_function(k)
        self._bucket_delitem(j, k)                                        # may raise KeyError
        self._n -= 1

    def _resize(self, c):
        """Resize bucket array to capacity c and rehash all items."""
        old = list(self.items())             # use iteration to record existing items
        self._table = c * [None]             # then reset table to desired capacity
        self._n = 0                                        # n recomputed during subsequent adds
        for (k,v) in old:
            self[k] = v                                    # reinsert old key-value pair

    def _bucket_getitem(self, j, k):
        raise NotImplementedError("Must be implemented by child class")

    def _bucket_setitem(self, j, k, v):
        raise NotImplementedError("Must be implemented by child class")

    def _bucket_delitem(self, j, k):
        raise NotImplementedError("Must be implemented by child class")

    def __iter__(self):
        raise NotImplementedError("Must be implemented by child class")

        
class ProbeHashMap(HashMapBase):
    """Hash map implemented with linear probing for collision resolution."""
    _AVAIL = object()             # sentinel marks locations of previous deletions
    probes = 0

    def _is_available(self, j):
        """Return True if index j is available in table."""
        return self._table[j] is None or self._table[j] is ProbeHashMap._AVAIL

    def _find_slot(self, j, k):
        """Search for key k in bucket at index j.

        Return (success, index) tuple, described as follows:
        If match was found, success is True and index denotes its location.
        If no match found, success is False and index denotes first available slot.
        """
        firstAvail = None
        while True:
            ProbeHashMap.probes += 1
            if self._is_available(j):
                if firstAvail is None:
                    firstAvail = j                                            # mark this as first avail
                if self._table[j] is None:
                    return (False, firstAvail)                    # search has failed
            elif k == self._table[j]._key:
                return (True, j)                                            # found a match
            j = (j + 1) % len(self._table)                    # keep looking (cyclically)

    def _bucket_getitem(self, j, k):
        found, s = self._find_slot(j, k)
        if not found:
            raise KeyError('Key Error: ' + repr(k))                # no match found
        return self._table[s]._value

    def _bucket_setitem(self, j, k, v):
        found, s = self._find_slot(j, k)
        if not found:
            self._table[s] = self._Item(k,v)                             # insert new item
            self._n += 1                                                                     # size has increased
        else:
            self._table[s]._value = v                                            # overwrite existing

    def _bucket_delitem(self, j, k):
        found, s = self._find_slot(j, k)
        if not found:
            raise KeyError('Key Error: ' + repr(k))                # no match found
        self._table[s] = ProbeHashMap._AVAIL                         # mark as vacated

    def __iter__(self):
        for j in range(len(self._table)):                                # scan entire table
            if not self._is_available(j):
                yield self._table[j]._key

        
class ChainHashMap(HashMapBase):
    """Hash map implemented with separate chaining for collision resolution."""

    probes = 0

    def _bucket_getitem(self, j, k):
        bucket = self._table[j]
        if bucket is None:
            raise KeyError('Key Error: ' + repr(k))                # no match found
        return bucket[k]                                                                 # may raise KeyError

    def _bucket_setitem(self, j, k, v):
        ChainHashMap.probes += 1
        if self._table[j] is None:
            self._table[j] = UnsortedTableMap()         # bucket is new to the table
        oldsize = len(self._table[j])
        self._table[j][k] = v
        if len(self._table[j]) > oldsize:                 # key was new to the table
            self._n += 1                                                        # increase overall map size

    def _bucket_delitem(self, j, k):
        bucket = self._table[j]
        if bucket is None:
            raise KeyError('Key Error: ' + repr(k))                # no match found
        del bucket[k]                                                                        # may raise KeyError

    def __iter__(self):
        for bucket in self._table:
            if bucket is not None:                                                 # a nonempty slot
                for key in bucket:
                    yield key


class QuadHashMap(HashMapBase):
    
    _AVAIL = object()
    probes = 0
    
    def _is_available(self, j):
        return self._table[j] is None or self._table[j] is QuadHashMap._AVAIL
    
    def _find_slot(self, j, k):
        firstAvail = None
        i = 0
        x = j
        while True:
            QuadHashMap.probes += 1
            if self._is_available(j):
                if firstAvail is None:
                    firstAvail = j
                if self._table[j] is None:
                    return (False, firstAvail)
            elif k == self._table[j]._key:
                return (True, j)
            j = (x + i**2) % len(self._table)
            i += 1
    
    def _bucket_getitem(self, j, k):
        success, i = self._find_slot(j, k)
        if not success:
            raise KeyError('Could not find: ' + repr(k))
        return self._table[i]._value
    
    def _bucket_setitem(self, j, k, v):
        success, i = self._find_slot(j, k)
        if not success:
            self._table[i] = self._Item(k, v)
            self._n += 1
        else:
            self._table[i]._value = v

    def _bucket_delitem(self, j, k):
        success, i = self._find_slot(j, k)
        if not success:
            raise KeyError('Could not find: ' + repr(k))
        self._table[i] = QuadHashMap._AVAIL
    
    def __iter__(self):
        for i in range(len(self._table)):
            if not self._is_available(i):
                yield self._table[i]._key

class DoubleHashMap(HashMapBase):
    
    _AVAIL = object()
    probes = 0
    
    def _hash_prime(self, k, q):
        return q - (hash(k) % q)
    
    def _is_available(self, j):
        return self._table[j] is None or self._table[j] is DoubleHashMap._AVAIL
    
    def _find_slot(self, j, k):
        firstAvail = None
        i = 0
        x = j
        while True:
            DoubleHashMap.probes += 1
            if self._is_available(j):
                if firstAvail is None:
                    firstAvail = j
                if self._table[j] is None:
                    return (False, firstAvail)
            elif k == self._table[j]._key:
                return (True, j)
            j = (x + (i * self._hash_prime(k, 827))) % len(self._table)
            i += 1
    
    def _bucket_getitem(self, j, k):
        success, i = self._find_slot(j, k)
        if not success:
            raise KeyError('Could not find: ' + repr(k))
        return self._table[i]._value
    
    def _bucket_setitem(self, j, k, v):
        success, i = self._find_slot(j, k)
        if not success:
            self._table[i] = self._Item(k, v)
            self._n += 1
        else:
            self._table[i]._value = v

    def _bucket_delitem(self, j, k):
        success, i = self._find_slot(j, k)
        if not success:
            raise KeyError('Could not find: ' + repr(k))
        self._table[i] = DoubleHashMap._AVAIL
    
    def __iter__(self):
        for i in range(len(self._table)):
            if not self._is_available(i):
                yield self._table[i]._key

def out_probes():
    print("Probes:", DoubleHashMap.probes)

def analysis():
    allwords = []
    with open("words.txt", "r") as file:
        for line in file.readlines():
            for word in line.split(" "):
                allwords.append(word)
    cap = 4261
    milestones = []
    for i in range(5, 101, 5):
        milestones.append(cap * (i / 100))
    t1 = ProbeHashMap(cap)
    t2 = ChainHashMap(cap)
    t3 = QuadHashMap(cap)
    t4 = DoubleHashMap(cap)
    t = t4
    for word in allwords:
        t[word] = word
        if len(t) > milestones[0]:
            print(milestones[0] / cap)
            out_probes()
            del milestones[0]
            if len(milestones) == 0:
                break

analysis()

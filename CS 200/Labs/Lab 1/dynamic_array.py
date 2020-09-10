# Largely taken from Goodrich et al., Code Fragment 5.3 (p. 196)
# Intended to serve as a simplified version of a python list, to explain how they work

import ctypes                                       # Provides low-level arrays


class DynamicArray:
    """A dynamic array class akin to a simplified Python list."""

    def __init__(self):
        """Create an empty array"""
        self._n = 0                                 # Count actual elements
        self._capacity = 1                          # Default array capacity
        self._A = self._make_array(self._capacity)  # Low-level array

    def __len__(self):
        """Return number of elements stored in the array"""
        return self._n

    def __getitem__(self, k):
        """Return element at index k."""
        if k >= self._n:
            raise IndexError('Invalid index')
        elif k < 0:
            # negative index
            # make sure not "too" negative
            if -k > self._n:
                raise IndexError("Invalid index")
            # set k to the positive equivlent
            k = self._n + k
        return self._A[k]                           # Retrieve from array
    
    def __setitem__(self, k, val):
        """Set an element at index k."""
        if k >= self._n or k < 0:
            raise IndexError("Index out of bounds")
        self._A[k] = val

    def append(self, obj):
        """Add object to end of the array."""
        if self._n == self._capacity:               # Not enough room, double capacity
            self._resize(2 * self._capacity)
        self._A[self._n] = obj
        self._n += 1

    # Code Fragment 5.5 (p. 204)
    def insert(self, k, value):
        """Insert value at index k, shifting subsequent values rightward."""
        # For simplicity, assumes that 0 <= k <= n
        if self._n == self._capacity:               # Not enough room, double capacity
            self._resize(2 * self._capacity)
        for j in range(self._n, k, -1):             # Shift rightmost first, then move left
            self._A[j] = self._A[j-1]
        self._A[k] = value                          # Store newest element
        self._n += 1

    # Code Fragment 5.6 (p. 206)
    def remove(self, value):
        """Remove first occurrence of value (or raise ValueError)."""
        # Does not consider shrinking the array in this version
        for k in range(self._n):
            if self._A[k] == value:                 # Found a match!
                for j in range(k, self._n - 1):     # Shift other elements to fill the gap
                    self._A[j] = self._A[j+1]
                self._A[self._n - 1] = None         # Fill the old last spot with None
                self._n -= 1                        # Reduce size
                return                              # Exit the function immediately, since we were successful
        raise ValueError('Value not found')
    
    def pop(self):
        """Remove and return the last element"""
        if self._n == 0:
            raise ValueError("Cannot call pop() when empty")
        # get and remove the last element
        last = self[-1]
        self._A[-1] = None
        self._n -= 1
        # check capacity
        if self._n < self._capacity / 4:
            self._resize(self.capacity / 2)
        return last
    
    def lab1_v1(self):
        import random
        for x in range(self._n):
            for y in range(x+1, self._n):
                z = random.randint(0, y-x)
                temp = self._A[x]
                self._A[x] = self._A[x+z]
                self._A[x+z] = temp
            
    def lab1_v2(self):
        import random
        for i in range(10):
            for j in range(self._n):
                k = random.randint(0,self._n-1)
                temp = self._A[j]
                self._A[j] = self._A[k]
                self._A[k] = temp

    def _resize(self, c):                           # Non-public utility function
        """Resize internal array to capacity c."""
        B = self._make_array(c)                     # New, bigger array
        for k in range(self._n):                    # For each existing value
            B[k] = self._A[k]
        self._A = B                                 # B is now the array
        self._capacity = c

    def _make_array(self, c):                       # Non-public utility function
        """Return new array with capacity c."""
        return (c * ctypes.py_object)()

    def __eq__(self, other):
        """Return whether or not two dynamic arrays are equal in length and content"""
        # check for equal lengths
        if self._n != len(other):
            return False
        # check for equal contents
        for i in range(self._n):
            if self._A[i] == other[i]:
                continue
            else:
                return False
        return True

    def __str__(self):
        """Return a string represntation of the array."""
        s = '['
        for i in range(self._n):
            if i != 0:
                s += ', '
            s += str(self._A[i])
        s += ']'
        return s
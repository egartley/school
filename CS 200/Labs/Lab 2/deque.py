DUMMY = "dummy"

class Deque:
    """ A circular doubly linked list that can only be modified at the beginning or end """
    
    class _Node:
        """ Linked list node for use with the deque """
        def __init__(self, e, p, n):
            self._element = e
            self._prev = p
            self._next = n
    
    def __init__(self):
        """ Create an empty deque with dummy head and tail """
        self.__size = 0
        self.__head = self._Node(DUMMY, None, None)
        self.__tail = self._Node(DUMMY, self.__head, self.__head)
        self.__head._next = self.__tail
        self.__head._prev = self.__tail
    
    def add_to_front(self, x):
        """ Add the specified item to the front/beginning of the deque """
        # "old" front
        prevfirst = self.__head._next
        # create new node to add
        newnode = self._Node(x, self.__head, self.__head._next)
        # update links/size
        self.__head._next = newnode
        prevfirst._prev = newnode
        self.__size += 1
    
    def add_to_end(self, x):
        """ Add the specified item to the end of the deque """
        # "old" end
        beforetail = self.__tail._prev
        # create new node to add
        newnode = self._Node(x, beforetail, self.__tail)
        # update links/size
        beforetail._next = newnode
        self.__tail._prev = newnode
        self.__size += 1
    
    def remove_from_front(self):
        """ Remove the first node in a non-empty deque """
        toremove = self.__head._next
        if toremove == self.__tail:
            # there's only the dummy nodes, so it's empty
            raise IndexError("Deque cannot be empty")
        other = toremove._next
        # update links/size
        other._prev = self.__head
        self.__head._next = other
        self.__size -= 1
        return toremove._element
    
    def remove_from_end(self):
        """ Remove the last node in a non-empty deque """
        toremove = self.__tail._prev
        if toremove == self.__head:
            # there's only the dummy nodes, so it's empty
            raise IndexError("Deque cannot be empty")
        other = toremove._prev
        # update links/size
        other._next = self.__tail
        self.__tail._prev = other
        self.__size -= 1
        return toremove._element
    
    def __len__(self):
        """ Return the amount of non-dummy nodes """
        return self.__size
    
    def __str__(self):
        """ String representation of the deque (without dummy nodes) """
        string = '['
        current = self.__head
        while current is not None:
            if current._element == DUMMY:
                current = current._next
                if current == self.__head:
                    current = None
                continue
            string += str(current._element)
            current = current._next
            if current is not None and current != self.__tail:
                string += ', '
        string += ']'
        return string
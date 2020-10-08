import copy
import stacks


class Queue:
    def __init__(self):
        self.stackA = stacks.LinkedStack()
        self.stackB = stacks.LinkedStack()
        self.size = 0

    def is_empty(self):
        """Tests if the queue is logically empty"""
        return self.stackA.is_empty()

    def make_copy(self):
        r = Queue()
        r.size = self.size
        r.stackA = self.stackA.make_copy()
        r.stackB = self.stackB.make_copy()
        return r

    def enqueue(self, item):
        """Puts item into the back of the queue"""
        self.stackA.push(item)
        oldb = self.stackB.make_copy()
        self.stackB = stacks.LinkedStack()
        self.stackB.push(item)
        while not oldb.is_empty():
            self.stackB.push(oldb.pop())
        self.size += 1

    def dequeue(self):
        """Returns and removes the element at the front of the queue, if it exists.

        Raises an IndexError if the queue is empty.
        """
        if self.is_empty():
            raise IndexError('Queue cannot be empty')
        r = self.stackB.pop()
        olda = self.stackA.make_copy()
        self.stackA = stacks.LinkedStack()
        skip = True
        while not olda.is_empty():
            if skip:
                skip = False
                olda.pop()
                continue
            self.stackA.push(olda.pop())
        self.size -= 1
        return r

    def first(self):
        """Returns the element at the front of the queue, if it exists.

        Raises an IndexError if the queue is empty.
        """
        if self.is_empty():
            raise IndexError('Queue cannot be empty')
        return self.stackB.top()

    def __len__(self):
        """Returns the size of the queue."""
        return self.size

    def __str__(self):
        out = "["
        tempstack = self.stackA.make_copy()
        while not (tempstack.is_empty()):
            out += str(tempstack.pop())
            if len(tempstack) >= 1:
                out += ", "
        return out + "]"

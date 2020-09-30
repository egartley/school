EMPTYNODE = "EMPTY"


class LeakyArrayStack:

    def __init__(self, capacity):
        """ Create an empty leaky array stack with the specified capacity """
        self.__data = []
        self.__capacity = capacity
        if self.__capacity < 1:
            raise ValueError("Maximum capacity must be at least 1")
        for c in range(self.__capacity):
            self.__data.append(None)

    def push(self, item):
        """ Add an item to the stack while removing the last one if at capacity """
        self.__data = self.__data[1:] + [item]

    def pop(self):
        """ Return and remove the 'first' item in the stack """
        if self.is_empty():
            raise IndexError("LeakyArrayStack cannot be empty when calling pop")
        removed = self.__data[-1]
        self.__data = [None] + self.__data[:-1]
        return removed

    def top(self):
        """ Return the 'first' item in the stack """
        if self.is_empty():
            raise IndexError("LeakyArrayStack cannot be empty when calling top")
        return self.__data[-1]

    def is_empty(self):
        """ Return whether or not the last element in the internal list is None """
        return self.__data[-1] is None

    def __len__(self):
        """ Return the amount of items that are able to be in the stack """
        return self.__capacity

    def __str__(self):
        """ String representation of leaky array stack """
        out = "["
        for i in range(self.__capacity):
            out += str(self.__data[i])
            if i + 1 < self.__capacity:
                out += ", "
        return out + "]"


class LeakyLinkedStack:
    class _Node:

        def __init__(self, e, n):
            """ Node for use with linked list for the stack """
            self.element = e
            self.next = n

    def __init__(self, capacity):
        """ Create an empty leaky linked stack with the specified capacity """
        self.__capacity = capacity
        if self.__capacity < 1:
            raise ValueError("Capacity must be greater than 1")
        self.__head = self._Node(EMPTYNODE, None)
        current = self.__head
        for c in range(self.__capacity - 1):
            node = self._Node(EMPTYNODE, None)
            current.next = node
            current = node
        self.__tail = current

    def push(self, item):
        """ Add an item to the stack while removing the last one if at capacity """
        current = self.__head
        while current is not None:
            if current.element is EMPTYNODE:
                break
            current = current.next
        if current is None:
            shift = self.__head
            last = shift.element
            while shift is not None:
                now = shift.next.element
                shift.next.element = last
                last = now
                shift = shift.next
                if shift.next is None:
                    break
            self.__head.element = item
        else:
            current.element = item

    def pop(self):
        """ Return and remove the 'first' item in the stack """
        if self.is_empty():
            raise IndexError("LeakyLinkedStack cannot be empty when calling pop")
        removed = self.__head.element
        self.__head.element = EMPTYNODE
        return removed

    def top(self):
        """ Return the 'first' item in the stack """
        if self.is_empty():
            raise IndexError("LeakyLinkedStack cannot be empty when calling top")
        return self.__head.element

    def is_empty(self):
        """ Return whether or not there's at least one item in the stack """
        return self.__head.element == EMPTYNODE if self.__tail.element == EMPTYNODE else self.__tail.element == EMPTYNODE

    def __len__(self):
        """ Return the amount of items that are able to be in the stack """
        return self.__capacity

    def __str__(self):
        """ String representation of leaky linked stack """
        out = "["
        current = self.__head
        while current is not None:
            out += str(current.element)
            current = current.next
            if current is not None:
                out += ", "
        return out + "]"


def main():
    las = LeakyArrayStack(5)
    print(las, "empty =", las.is_empty())
    las.push("A")
    print(las, "empty =", las.is_empty())
    las.push("B")
    las.push("C")
    las.push("D")
    las.push("E")
    print(las)
    las.push("F")
    print(las)
    print("top =", las.top())
    print("pop =", las.pop())
    print(las)
    print("pop =", las.pop())
    print(las)
    print()
    lls = LeakyLinkedStack(5)
    print(lls)
    lls.push("A")
    print(lls)
    lls.push("B")
    print(lls)
    lls.push("C")
    print(lls)
    lls.push("D")
    print(lls)
    lls.push("E")
    print(lls)
    lls.push("F")
    print(lls)
    lls.push("G")
    print(lls)
    print("top =", lls.top())
    print("pop =", lls.pop())
    print(lls)
    lls.push("X")
    print(lls)
    lls.push("Z")
    print(lls)


main()

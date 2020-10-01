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

        def __init__(self, e, p, n):
            """ Node for use with linked list for the stack """
            self.element = e
            self.prev = p
            self.next = n

    def __init__(self, capacity):
        """ Create an empty leaky linked stack with the specified capacity """
        self.__capacity = capacity
        if self.__capacity < 1:
            raise ValueError("Capacity must be greater than 1")
        self.__head = self._Node(EMPTYNODE, None, None)
        current = self.__head
        for c in range(self.__capacity - 1):
            node = self._Node(EMPTYNODE, current, None)
            current.next = node
            current = node
        self.__tail = current

    def push(self, item):
        """ Add the item to the stack, removing the last one if full """
        node = self._Node(item, None, self.__head)
        self.__head.prev = node
        self.__head = node
        self.__tail.prev.next = None
        self.__tail = self.__tail.prev

    def pop(self):
        """ Return and remove the 'first' item in the stack """
        if self.is_empty():
            raise IndexError("LeakyLinkedStack cannot be empty when calling pop")
        removed = self.__head.element
        self.__head = self.__head.next
        empty = self._Node(EMPTYNODE, self.__tail, None)
        self.__tail.next = empty
        self.__tail = empty
        return removed

    def top(self):
        """ Return the 'first' item in the stack """
        if self.is_empty():
            raise IndexError("LeakyLinkedStack cannot be empty when calling top")
        return self.__head.element

    def is_empty(self):
        """ Return whether or not there's at least one item in the stack """
        return self.__head.element == EMPTYNODE

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


def test(stack):
    print(stack, "empty =", stack.is_empty())
    stack.push("A")
    print(stack, "empty =", stack.is_empty())
    stack.push("B")
    print(stack)
    stack.push("C")
    print(stack)
    stack.push("D")
    print(stack)
    stack.push("E")
    print(stack)
    stack.push("F")
    print(stack)
    print("top =", stack.top())
    print("pop =", stack.pop())
    print(stack)
    print("pop =", stack.pop())
    print(stack)
    stack.push("X")
    print(stack)
    stack.push("Y")
    print(stack)
    stack.push("Z")
    print(stack)


def main():
    test(LeakyArrayStack(3))
    print("-"*52)
    test(LeakyLinkedStack(5))


main()

from dynamic_array import DynamicArray

# demostrate implementations
def main():
    test1 = DynamicArray()
    test2 = DynamicArray()
    for n in range(5, 11):
        test1.append(n)
        test2.append(n)
    print("Test 1:", test1)
    print("Test 2:", test2)
    print()
    # positive or negative index
    print("__getitem__")
    print("test1[3] =", test1[3])
    print("test2[-1] =", test2[-1])
    print()
    print("__setitem__")
    print("Test 1:", test1)
    print("Test 2:", test2)
    test1[1] = 7
    test2[0] = 9
    print("test1[1] = 7")
    print("test2[0] = 9")
    print("Test 1:", test1)
    print("Test 2:", test2)
    print()
    # return, resize
    print("pop")
    print("Test 1:", test1)
    print("Test 2:", test2)
    print("test1.pop() =", test1.pop())
    print("test2.pop() =", test2.pop())
    print("Test 1:", test1)
    print("Test 2:", test2)
    print()
    # contents/length equal
    print("__eq__")
    test3 = DynamicArray()
    for i in range(len(test2)):
        test3.append(test2[i])
    test4 = DynamicArray()
    for i in range(10):
        test4.append(i)
    print("Test 1:", test1)
    print("Test 2:", test2)
    print("Test 3:", test3)
    print("Test 4:", test4)
    print("test1 == test2 =", test1 == test2)
    print("test2 == test3 =", test2 == test3)
    print("test4 == test1 =", test4 == test1)

main()
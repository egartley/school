import timeit
from random import randint
from sorting import *


def do_test(n):
    print("Running for n =", n)
    print("Random")
    numbers = []
    for i in range(n):
        numbers.append(randint(0, 10 * n))
    try:
        start = timeit.default_timer()
        radix_sort(numbers)
        end = timeit.default_timer()
        print("\tTime taken:", end - start)
    except RecursionError:
        print("\tTime taken: ERR")

    print("Sorted")
    numbers = []
    for i in range(n):
        numbers.append(i)
    try:
        start2 = timeit.default_timer()
        radix_sort(numbers)
        end2 = timeit.default_timer()
        print("\tTime taken:", end2 - start2)
    except RecursionError:
        print("\tTime taken: ERR")

    print("Reverse")
    numbers = []
    for i in range(n, 0, -1):
        numbers.append(i)
    try:
        start3 = timeit.default_timer()
        radix_sort(numbers)
        end3 = timeit.default_timer()
        print("\tTime taken:", end3 - start3)
    except RecursionError:
        print("\tTime taken: ERR")
    print()


def main():
    # import sys
    # sys.setrecursionlimit(4500)
    do_test(100)
    do_test(1000)
    do_test(10000)
    do_test(100000)


main()

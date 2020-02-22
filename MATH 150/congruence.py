print("a = b % n")
a = int(input("a: "))
b = int(input("b: "))
n = int(input("n: "))

if a % n == b % n:
    print("True, since they both have the same modulous result")
else:
    print("False, since they have different modulous results")
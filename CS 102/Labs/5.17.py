n1 = int(input())
n2 = int(input())

if n1 > n2:
    print("Second integer can't be less than the first.")
else:
    while n1 <= n2:
        print(n1, end=" ")
        n1 += 10
    print()

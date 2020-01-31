n = int(input())

if n < 20 or n > 98:
    print("Input must be 20-98")
else:
    while n % 11 != 0:
        print(n)
        n -= 1
    print(n)

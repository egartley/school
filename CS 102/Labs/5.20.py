numbers = []

n = int(input())

while n > 0:
    numbers.append(n)
    n = int(input())
    
print(min(numbers), max(numbers))

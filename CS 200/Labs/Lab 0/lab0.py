# Evan Gartley Section 03
# Lab 0

# returns the difference between the largest and smallest numbers in the list
def difference(numbers):
    minimum = numbers[0]
    maximum = numbers[len(numbers) - 1]
    
    for number in numbers:
        minimum = number if number < minimum else minimum
        maximum = number if number > maximum else maximum
    
    return maximum - minimum

# returns the sum of cubed even numbers less than the given number
def sum_even_cubes(number):
    number -= 1
    total = 0
    while number > 0:
        if number % 2 == 0:
            total += number**3
        number -= 1
    return total

# returns whether or not the list contains duplicate elements
def has_duplicate(numbers):
    elements = []
    for number in numbers:
        if number in elements:
            return True
        else:
            elements.append(number)
    return False

# returns a list of products produced by the two lists' corresponding elements
def list_product(a, b):
    products = []
    for i in range(len(a)):
        products.append(a[i] * b[i])
    return products

def main():
    print(difference([1, 2, 3, 4, 5]))
    print(difference([10, 7, 42, 107, 53, 99]))
    print(difference([0.5, 0.25, 0.4, 0.9, -0.1]))
    print(difference([5, 5, 5, 5, 5]))
    print()
    print(sum_even_cubes(5))
    print(sum_even_cubes(6))
    print(sum_even_cubes(9))
    print(sum_even_cubes(2))
    print()
    print(has_duplicate([7,0,3,0]))
    print(has_duplicate([7,6,5,4,3,2,1,0]))
    print(has_duplicate([]))
    print()
    print(list_product([1,2,3], [4,5,6]))
    print(list_product([2,2,2,2], [7,8,9,10]))

main()
def max_magnitude(num1, num2):
    if abs(num1) > abs(num2):
        return num1
    else:
        return num2

if __name__ == '__main__':
    print(max_magnitude(int(input()), int(input())))

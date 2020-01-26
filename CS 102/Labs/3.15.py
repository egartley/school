num1 = float(input())
num2 = float(input())
num3 = float(input())
num4 = float(input())

product = num1 * num2 * num3 * num4
average = (num1 + num2 + num3 + num4) / 4.0

print('{:.0f} {:.0f}'.format(product, average))
print('{:.3f} {:.3f}'.format(product, average))

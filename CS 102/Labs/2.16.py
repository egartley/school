import math

x = float(input())
y = float(input())
z = float(input())
print("{:.2f} {:.2f} {:.2f} {:.2f}".format(x**z, x**(y**z), abs(x - y), math.sqrt(x**z)))

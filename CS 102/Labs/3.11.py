base_char = input()
head_char = input()

row1 = '      ' + head_char
row2 = '{0}{0}{0}{0}{0}{0}'.format(base_char) + head_char + head_char
row3 = row2 + head_char

print(row1)
print(row2)
print(row3)
print(row2)
print(row1)

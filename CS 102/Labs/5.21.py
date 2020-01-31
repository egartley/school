symbol = input('Enter a character:\n')
height = int(input('Enter triangle height:\n'))
print("")

i = 1

while i <= height:
    out = ""
    for n in range(i):
        out += symbol + " "
    print(out)
    i += 1

base_height = int(input('Enter arrow base height:\n'))

base_width = int(input('Enter arrow base width:\n'))

head_width = int(input('Enter arrow head width:\n'))

while head_width <= base_width:
    head_width = int(input('Enter arrow head width:\n'))

print()
for h in range(base_height):
    for w in range(base_width):
        print("*", end="")
    print()

for h in range(head_width):
    for w in range(head_width - h):
        print("*", end="")
    print()

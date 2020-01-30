directions = ["east/west", "north/south"]

num = int(input())
direction = directions[num % 2]

if num == 0 or num > 999:
    print(num, "is not a valid interstate highway number.")
elif num < 100:
    print("I-{} is primary, going {}.".format(num, direction))
else:
    print("I-{} is auxiliary, serving I-{}, going {}.".format(num, num % 100, direction))

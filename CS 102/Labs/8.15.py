full = input()
splits = full.split(" ")
if len(splits) == 3:
    print("{}, {}.{}.".format(splits[2], splits[0][0], splits[1][0]))
else:
    print("{}, {}.".format(splits[1], splits[0][0]))

end = ("Quit", "quit", "q")

s = input()

while not(s in end):
    r = []
    for c in s:
        r.append(c)
    r.reverse()
    for c in r:
        print(c, end="")
    print()
    s = input()

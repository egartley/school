name = input()
upper = input()
lower = input()

lines = [upper, lower]
original = []
for line in open(name).readlines():
    line = line.strip()
    if not(line is upper) and not(line is lower):
        lines.append(line)
    original.append(line)

lines.sort()

lines = lines[lines.index(upper):lines.index(lower) + 1]
if not(upper in original):
    lines.remove(upper)
if not(lower in original):
    lines.remove(lower)

# lazy fix
if lines[0] == lines[1]:
    lines.pop(0)

for line in lines:
    print(line)

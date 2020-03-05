pairs = []
for pair in input().split("   "):
    p = pair.split(" ")
    pairs.append([p[0], p[1]])
sentence = input()
for pair in pairs:
    sentence = sentence.replace(pair[0], pair[1])
print(sentence)

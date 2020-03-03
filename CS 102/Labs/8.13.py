text = input()
words = text.split(" ")
letters = []
for word in words:
    if word[0].isupper():
        letters.append(word[0])
for letter in letters:
    print(letter, end="")
print()

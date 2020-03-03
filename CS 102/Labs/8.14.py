letter = input()
words = input()
for word in words.split(" "):
    if word.find(letter) != -1:
        print(word)

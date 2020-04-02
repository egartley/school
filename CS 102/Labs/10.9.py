import csv

def count_word(dictionary, word):
    if word in dictionary:
        dictionary[word] += 1
    else:
        dictionary[word] = 1
    return dictionary

name = input()
words = {}

with open(name, mode="r") as file:
    reader = csv.reader(file, delimiter=",")
    for row in reader:
        for word in row:
            words = count_word(words, word)

for word in words:
    print(word, words[word])

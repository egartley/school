# returns the sentence without punctuation (period, comma, question mark, etc.)
def remove_punctuation(sentence):
    puncs = ["!", ",", ".", "?", ":", ";", "-", "'", "*", "#", "$", "&"]
    for punc in puncs:
        # replace any punctuation with an empty string
        sentence = sentence.replace(punc, "")
    return sentence

# returns the dictionary with either the word added if not already existing, or incrementing the count for the word otherwise
def add_word(dictionary, word):
    if word in dictionary:
        # increment the word's count
        dictionary[word] += 1
    else:
        # add the word since it's not in the dictionary, with a count of 1
        dictionary[word] = 1
    return dictionary

# returns a dictionary containing the amounts of each word in the sentence
def word_count(sentence):
    # strip the sentence of any punctuation
    sentence = remove_punctuation(sentence)
    dictionary = {}
    for word in sentence.split(" "):
        # add each word or update its count
        dictionary = add_word(dictionary, word)
    return dictionary

# updates and returns the dictionary with keys of the word's letter, and values of the word
def add_letter(dictionary, word):
    # go through each letter in the "clean" word
    for letter in remove_punctuation(word.lower()):
        if not(letter in dictionary):
            # add letter to dictionary for first time with the word
            dictionary[letter] = [word]
        elif not(word in dictionary[letter]):
            # add the word to the letter, avoiding repeats
            dictionary[letter].append(word)
    return dictionary

# returns a dictionary with each letter has keys and the values being what words contain those letters
def letter_to_word_mapping(sentence):
    # isolate each word
    words = remove_punctuation(sentence.lower()).split(" ")
    dictionary = {}
    # go through each word from the sentence
    for word in words:
        dictionary = add_letter(dictionary, word)
    return dictionary

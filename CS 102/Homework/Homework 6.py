# swaps the characters at location 1 and 2 in the specified string text
def swap(text, location1, location2):
    # subtract 1 to make the locations zero-based
    location1 -= 1
    location2 -= 1
    s1 = text[location1]
    s2 = text[location2]
    result = ""
    for i in range(len(text)):
        # rebuild the string with the two swapped characters
        if i == location1:
            result += s2
        elif i == location2:
            result += s1
        else:
            result += text[i]
    return result

# uncompresses and returns the specified string text with the quantity before each letter
def uncompress(text):
    result = ""
    i = 0
    again = True
    while again:
        # get how many letters to add
        length = 0
        if text[i].isdigit() and text[i+1].isdigit():
            length = int(text[i] + text[i+1])
            i += 1
        else:
            length = int(text[i])
        # append the amount of the letter 
        result += text[i + 1] * length
        # check if done
        if i + 2 >= len(text):
            again = False
        # go to next number and letter
        i += 2
    return result

# returns the longest word in the specified string of compressed words
def longestword(text):
    words = text.split(" ")
    # uncompress each word
    for i in range(len(words)):
        words[i] = uncompress(words[i])
    # find the longest word of the uncompressed
    maxlength = 0
    maxword = ""
    for word in words:
        if len(word) > maxlength:
            maxlength = len(word)
            maxword = word
    print(maxword, maxlength)

# returns a password generated with the phrase and gibberish
def gen_password(phrase, gibberish):
    # reverse the original phrase
    password = phrase[::-1]
    vowels = ["a", "e", "i", "o", "u"]
    # replace each vowel with the gibberish
    for c in password:
        if c in vowels:
            password = password.replace(c, gibberish)
    return password

if __name__ == "__main__":
    longestword(input())
from stacks import *
import copy
import lab4_queue


def read_dictionary(filename):
    """Reads the file containing the list of words and stores it in wordlist"""
    wordlist = dict()  # This will contain all of the words

    file = open(filename, 'r')
    for line in file:
        word = line.strip()
        length = len(word)
        if length in wordlist:
            wordlist[length].append(word)
        else:
            wordlist[length] = [word]

    return wordlist


def oneletterdiff(a, b):
    once = False
    for i in range(len(a)):
        x = a[i:i + 1]
        y = b[i:i + 1]
        if x != y:
            if once:
                return False
            else:
                once = True
    return True


def is_valid_ladder(ladder, end):
    return ladder.top() == end


def build_ladder(start, end):
    """Finds the shortest word ladder that connects start and end words.
    
    Returns None if such a ladder does not exist.
    """

    if len(start) != len(end):
        return None

    wordlist = read_dictionary('dictionary.txt')  # Contains all of the allowed words

    used = set()  # This will be a set of words that you have used while you searched

    ladders = lab4_queue.Queue()  # This is your queue of stacks that will hold all of the word ladders in progress

    allwords = wordlist[len(start)]
    for word in allwords:
        if word != start and oneletterdiff(word, start):
            stack = ArrayStack()
            stack.push(start)
            stack.push(word)
            if word == end:
                return stack
            ladders.enqueue(stack)
    done = False
    while not done:
        stack = ladders.dequeue()
        top = stack.top()
        nowords = True
        for word in allwords:
            if word != start and word != top and not(stack.has(word)) and oneletterdiff(word, top):
                nowords = False
                s = copy.deepcopy(stack)
                s.push(word)
                if word == end:
                    return s
                ladders.enqueue(s)
        done = nowords

    return None

import random

def number_guess(num):
    r = random.randint(1, 100)
    if (r == num):
        print(num, "is correct!")
    elif (r < num):
        print(num, "is too high. Random number was {}.".format(r))
    else:
        print(num, "is too low. Random number was {}.".format(r))
        
if __name__ == "__main__":
    random.seed(900)
    user_input = input()
    tokens = user_input.split()
    for token in tokens:
        num = int(token)
        number_guess(num)

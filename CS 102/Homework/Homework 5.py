import random

def is_equal(num1, num2):
    return num1 == num2

def my_random(low, high):
    random.seed(10)
    return max(random.randint(low, high), random.randint(low, high))
    
def roll_dice(num_dice, sides):
    # random number between 1 and sides, num_dices amount of times
    for n in range(num_dice):
        print(random.randint(1, sides), end = " ")
    print()
        
def roll_no_pair_dice(num_dice, sides):
    while num_dice > 0:
        roll1 = random.randint(1, sides)
        roll2 = random.randint(1, sides)
        if not(is_equal(roll1, roll2)):
            # the two numbers weren't the same, count as a roll
            num_dice -= 1
            print(roll1, roll2)

def main():
    random.seed(10)
    roll_dice(4, 8)
    roll_dice(5, 10)
    random.seed(10)
    roll_no_pair_dice(5, 10)
    
main()
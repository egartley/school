from linked_binary_tree import LinkedBinaryTree

class Guesser(LinkedBinaryTree):
    
    def __init__(self, question, ans1, ans2):
        super().__init__()
        self._add_root(question)
        r = self.root()
        self._add_left(r, ans1)
        self._add_right(r, ans2)

    def add_question(self, p, question, answer):
        self._add_right(p, question)
        self._add_left(self.right(p), answer)
        self._add_right(self.right(p), p.element())

def is_yes(answer):
    return answer.strip().lower() == "yes"

def is_no(answer):
    return answer.strip().lower() == "no"

def ask(guess):
    current = guess.root()
    won = False
    while not won:
        answer = input(current.element() + " ")
        check = guess.left(current) if is_yes(answer) else guess.right(current)
        if "?" in check.element():
            current = check
        else:
            answer = input("Is it a(n) " + check.element() + "? ")
            if is_yes(answer):
                return is_yes(input("I win!. Continue? "))
            elif is_no(answer) and not(guess.num_children(check)):
                animal = input("I give up. What is it? ")
                question = input("Please type a question whose answer is yes for " + animal + " and no for " + check.element() + ": ")
                guess.add_question(check, question, animal)
                return is_yes(input("Continue? "))
            else:
                current = guess.right(check)
        

def play_game():
    load = is_yes(input("Load game? "))
    if not load:
        guess = Guesser("Does it have legs?", "cat", "snake")
        print()
    else:
        guess = LinkedBinaryTree.load_tree("tree.dat")
        print("Loaded\n")
    again = True
    while again:
        print("Think of an animal, and I will guess it.")
        again = ask(guess)
        if again:
            print()
    if is_yes(input("Save game? ")):
        guess.save_tree("tree.dat")
        print("Saved")

play_game()
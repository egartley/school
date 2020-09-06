# Evan Gartley Section 03
# Lab 0

# a dog with an age, name and breed
class Dog:
    def __init__(self, name, age, breed):
        self.name = name
        self.age = age
        self.breed = breed

    def get_name(self):
        return self.name
    
    def get_age(self):
        return self.age
    
    def get_breed(self):
        return self.breed
    
    def set_name(self, name):
        self.name = name
    
    def set_age(self, age):
        self.age = age
    
    def set_breed(self, breed):
        self.breed = breed

def main():
    golden = Dog("Dog1", 6, "Golden Retriever")
    print(golden.get_name(), golden.get_age(), golden.get_breed())
    golden.set_age(4)
    golden.set_name("Dog2")
    golden.set_breed("Black Lab")
    print(golden.get_name(), golden.get_age(), golden.get_breed())

main()
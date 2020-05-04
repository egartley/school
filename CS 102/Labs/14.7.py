class Pet:
    def __init__(self):
        self.name = ''
        self.age = 0

    def print_info(self):
        print('Pet Information:')
        print('   Name:', self.name)
        print('   Age:', self.age)

class Dog(Pet):
    def __init__(self):
        Pet.__init__(self) 
        self.breed = ''
    
    def print_info(self):
        Pet.print_info(self)
        print('   Breed:', self.breed)

my_pet = Pet()
my_dog = Dog()

pet_name = input()
pet_age = int(input())
dog_name = input()
dog_age = int(input())
dog_breed = input()

my_pet.name = pet_name
my_pet.age = pet_age
my_pet.print_info()

my_dog.name = dog_name
my_dog.age = dog_age
my_dog.breed = dog_breed
my_dog.print_info()

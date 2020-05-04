class Horse:
    
    def __init__(self, name, color, birth_year):
        self.name = name
        self.color = color
        self.birth_year = birth_year
    
    def get_name(self):
        return self.name
    
    def get_color(self):
        return self.color
    
    def get_birth_year(self):
        return self.birth_year
    
    def get_age_at(self, year):
        # ex. 2020 - 2012 = 8 years old
        return year - self.birth_year
    
    def __str__(self):
        return "Name: {} Color: {} Birth year: {}".format(self.name, self.color, self.birth_year)

class Stable:
    
    def __init__(self, stable_name, max_horses):
        self.stable_name = stable_name
        self.max_horses = max_horses
        self.horse_list = []
    
    def add_horse(self, horse):
        # check if there's room in the stable, don't add if full
        if len(self.horse_list) >= self.max_horses:
            print("No room to add horse!")
        else:
            self.horse_list.append(horse)
    
    def get_horse(self, name):
        # check if there's a horse with the same name
        for horse in self.horse_list:
            if horse.get_name() == name:
                return horse
        print("No such horse:", name)
    
    def __str__(self):
        print("Stable name:", self.stable_name)
        for horse in self.horse_list:
            print(horse)

if __name__ == "__main__":
    horse1 = Horse("Horse1", "Brown", 2013)
    horse2 = Horse("Horse2", "White", 2012)
    horse3 = Horse("Horse3", "Grey", 2012)
    stable = Stable("MyStable", 2)
    stable.add_horse(horse1)
    stable.add_horse(horse2)
    # test output for adding a horse to a full stable
    stable.add_horse(horse3)
    # test output for when an unknown horse is retrieved
    horse4 = stable.get_horse("Horse4")

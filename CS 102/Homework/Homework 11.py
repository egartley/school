class Phone:
    def __init__(self, name, phone_number):
        self.__name = name
        self.__phone_number = phone_number
        
    def get_name(self):
        return self.__name
    
    def set_name(self, name):
        self.__name = name
        
    def get_phone_number(self):
        return self.__phone_number
    
    def set_phone_number(self, phone_number):
        self.__phone_number = phone_number
        
    def __str__(self):
        return  "Name: " + self.__name + " Number: " + self.__phone_number
                 
class CellPhone(Phone):
    
    def __init__(self, name, number, battery):
        Phone.__init__(self, name, number)
        self.__battery = battery
        self.__apps = []
    
    def get_battery_life(self):
        return self.__battery
    
    def set_battery_life(self, battery):
        self.__battery = battery
    
    def get_apps(self):
        return self.__apps
    
    def add_app(self, app_name):
        if app_name not in self.__apps:
            # prevent adding the same app twice
            self.__apps.append(app_name)
    
    def del_app(self, app_name):
        if app_name in self.__apps:
            self.__apps.remove(app_name)
    
    def __str__(self):
        # name, number, battery life
        # app list
        out = Phone.__str__(self) + " Battery Life: " + str(self.__battery) + " \nApplications:  "
        for app in self.__apps:
            out += app + " "
        return out

class HomePhone(Phone):
    
    def __init__(self, name, number, address):
        Phone.__init__(self, name, number)
        self.__address = address
    
    def get_address(self):
        return self.__address
    
    def set_address(self, address):
        self.__address = address
    
    def __str__(self):
        # name, number, address
        return Phone.__str__(self) + " Address: " + self.__address

if __name__ == "__main__":
    pass

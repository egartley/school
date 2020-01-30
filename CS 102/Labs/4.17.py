months = ("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
months_int = range(1, 13)

month = input()
day = int(input())

valid = month in months and day > 0 and day < 32

if month == "February":
    valid = day < 30
elif month == "April" or month == "June" or month == "September" or month == "November":
    valid = day < 31
    
if not(valid):
    print("Invalid")
else:
    month = months_int[months.index(month)]
    
    #spring: mar 20 to jun 20
    if month == 4 or month == 5 or (month == 3 and day >= 20) or (month == 6 and day <= 20):
        print("Spring")
        
    #summer: jun 21 to sept 21
    elif month == 7 or month == 8 or (month == 6 and day >= 21) or (month == 9 and day <= 21):
        print("Summer")
        
    #fall: sept 22 to dec 20
    elif month == 10 or month == 11 or (month == 9 and day >= 22) or (month == 12 and day <= 20):
        print("Autumn")
        
    #winter: not any other season, must be winter
    else:
        print("Winter")

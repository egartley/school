months = ("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

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
    #spring: mar 20 to jun 20
    if month == "April" or month == "May" or (month == "March" and day >= 20) or (month == "June" and day <= 20):
        print("Spring")
    #summer: jun 21 to sept 21
    elif month == "July" or month == "August" or (month == "June" and day >= 21) or (month == "September" and day <= 21):
        print("Summer")
    #fall: sept 22 to dec 20
    elif month == "October" or month == "November" or (month == "September" and day >= 22) or (month == "December" and day <= 20):
        print("Autumn")
    #winter: month/day already valid, so it must be winter if not any of the other three seasons
    else:
        print("Winter")

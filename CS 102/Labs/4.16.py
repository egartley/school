year = int(input())
leap = False

if year % 4 == 0:
    leap = True
    if year % 100 == 0:
        if year % 400 != 0:
            leap = False

print(year, "-", "leap year" if leap else "not a leap year")

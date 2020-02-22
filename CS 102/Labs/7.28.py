def is_leap_year(year):
    return (year % 4 == 0 and year % 100 != 0) or (year % 100 == 0 and year % 400 == 0)

if __name__ == '__main__':
    year = int(input())
    
    if is_leap_year(year):
        print(year, "is a leap year.")
    else:
        print(year, "is not a leap year.")

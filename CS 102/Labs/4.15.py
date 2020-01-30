change = int(input())

if change <= 0:
    print("No change")
else:
    if change >= 100:
        n = change // 100
        print(str(n) + " Dollar" if n == 1 else str(n) + " Dollars")
        change -= 100 * n
        
    if change >= 25:
        n = change // 25
        print(str(n) + " Quarter" if n == 1 else str(n) + " Quarters")
        change -= 25 * n
        
    if change >= 10:
        n = change // 10
        print(str(n) + " Dime" if n == 1 else str(n) + " Dimes")
        change -= 10 * n
        
    if change >= 5:
        n = change // 5
        print(str(n) + " Nickel" if n == 1 else str(n) + " Nickels")
        change -= 5 * n
        
    if change > 1:
        print(change, "Pennies")
    elif change != 0:
        print(change, "Penny")

change = int(input())

if change <= 0:
    print("No change")
else:
    if change >= 100:
        n = change // 100
        out = str(n) + " Dollar" if n == 1 else str(n) + " Dollars"
        print(out)
        change -= 100 * n
    if change >= 25:
        n = change // 25
        out = str(n) + " Quarter" if n == 1 else str(n) + " Quarters"
        print(out)
        change -= 25 * n
    if change >= 10:
        n = change // 10
        out = str(n) + " Dime" if n == 1 else str(n) + " Dimes"
        print(out)
        change -= 10 * n
    if change >= 5:
        n = change // 5
        out = str(n) + " Nickel" if n == 1 else str(n) + " Nickels"
        print(out)
        change -= 5 * n
    if change > 1:
        print(change, "Pennies")
    elif change != 0:
        print(change, "Penny")

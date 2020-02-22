def exact_change(change):
    dollars = 0
    quarters = 0
    dimes = 0
    nickels = 0
    pennies = 0
    
    if change >= 100:
        dollars = change // 100
        change -= 100 * dollars
        
    if change >= 25:
        quarters = change // 25
        change -= 25 * quarters
        
    if change >= 10:
        dimes = change // 10
        change -= 10 * dimes
        
    if change >= 5:
        nickels = change // 5
        change -= 5 * nickels
        
    pennies = change
    
    return dollars,quarters,dimes,nickels,pennies

def out_change(quantity, word):
    if quantity > 0:
        if quantity == 1:
            print(quantity, word)
        else:
            print(quantity, "{}s".format(word))

if __name__ == '__main__':
    change = int(input())
    if change <= 0:
        print("no change")
        pass
    dollars, quarters, dimes, nickels, pennies = exact_change(change)

    out_change(dollars, "dollar")
    out_change(quarters, "quarter")
    out_change(dimes, "dime")
    out_change(nickels, "nickel")
    if pennies > 0:
        if pennies == 1:
            print(pennies, "penny")
        else:
            print(pennies, "pennies")

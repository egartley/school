# 2d array of fees based on income bracket, members of household
fees = [[5, 5, 5, 0], [20, 20, 15, 10], [30, 25, 25, 20], [40, 35, 35, 30]]

# gather informatiom
name = input()
income = int(input())
household = int(input())
college = input()
employee = input()

# correct household variable as an index for use with fees (zero-based, min/max)
household -= 1
if household > 3:
    household = 3
elif household < 0:
    household = 0
    
charge = 0

# check if theyre a college student
if college == "y":
    charge = 10
# check if theyre an employee
elif employee == "y":
    charge = 15
else:
    # not student/employee, therefore use income/household members
    if income <= 20000:
        # 0 - 20000
        charge = fees[0][household]
    elif income <= 50000:
        # 20001 - 50000
        charge = fees[1][household]
    elif income <= 80000:
        # 50001 - 80000
        charge = fees[2][household]
    else:
        # 80001+
        charge = fees[3][household]

# output name and charge
print("Patient:", name)
print("Charge: $", charge)

categories = {"snack": 0, "soup": 1, "salad": 1, "meal": 2, "drink": 3}
quanities = [0, 0, 0, 0]
totals = [0, 0, 0, 0]
customers = 0
overall_total = 0
another_customer = True

while another_customer:
    another_item = True
    customer_total = 0
    customers += 1
    while another_item:
        type = ""
        while not(type in categories) and type != "zzz":
            # ensure that the entered type is valid
            type = input("Enter type of item (snack, soup, salad, meal, drink; 'zzz' to quit): ").lower()
        
        another_item = type != "zzz"
        if another_item:
            price = float(input("Enter cost of the item: "))
            customer_total += price
            # determine index from type of item
            index = categories[type]
            # update quanities and totals for the category
            quanities[index] += 1
            totals[index] += price
            
    # update overall total with the customer's total
    overall_total += customer_total
    print("Customer total: ${:.2f}".format(customer_total))
    another_customer = input("Another customer? (y for yes): ") == "y"
    print("=======================================================")
    
print("Total number of customers is:", customers)
print("Total sold is: ${:.2f}".format(overall_total))

print("Total number of snacks sold is:", quanities[categories["snack"]])
print("Total value of snacks sold is: ${:.2f}".format(totals[categories["snack"]]))
print("Total number of soup or salad sold is:", quanities[categories["soup"]])
print("Total value of soup or salad sold is: ${:.2f}".format(totals[categories["soup"]]))
print("Total number of meals sold is:", quanities[categories["meal"]])
print("Total value of meals sold is: ${:.2f}".format(totals[categories["meal"]]))
print("Total number of drinks sold is:", quanities[categories["drink"]])
print("Total value of drinks sold is: ${:.2f}".format(totals[categories["drink"]]))

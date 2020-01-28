prices = {'Oil change': 35, 'Tire rotation': 19, 'Car wash': 7}

service = input("Enter desired auto service:\n")
print("You entered:", service)

if service in prices:
    print("Cost of {}{}: ${}".format(service[0].lower(), service[1:], prices[service]))
else:
    print("Error: Requested service is not recognized")

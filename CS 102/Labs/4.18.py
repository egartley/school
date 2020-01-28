prices = {"Oil change": 35, "Tire rotation": 19, "Car wash": 7, "Car wax": 12, "-": 0}

print("Davy's auto shop services\nOil change -- $35\nTire rotation -- $19\nCar wash -- $7\nCar wax -- $12\n")

service1 = input("Select first service:\n")
service2 = input("Select second service:\n")

charge1 = prices[service1]
charge2 = prices[service2]

total = charge1 + charge2

out1 = "No service" if service1 == "-" else service1 + ", $" + str(charge1)
out2 = "No service" if service2 == "-" else service2 + ", $" + str(charge2)

print("\nDavy's auto shop invoice\n\nService 1: {}\nService 2: {}\n\nTotal: ${}".format(out1, out2, total))

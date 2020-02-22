def driving_cost(miles, miles_gallon, dollars_gallon):
    return miles / miles_gallon * dollars_gallon

if __name__ == '__main__':
    miles_gallon = float(input())
    dollars_gallon = float(input())
    print("{:.2f}".format(driving_cost(10, miles_gallon, dollars_gallon)))
    print("{:.2f}".format(driving_cost(50, miles_gallon, dollars_gallon)))
    print("{:.2f}".format(driving_cost(400, miles_gallon, dollars_gallon)))

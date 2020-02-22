def miles_to_laps(miles):
    return miles * 4

if __name__ == '__main__':
    miles = float(input())
    print("{:.2f}".format(miles_to_laps(miles)))

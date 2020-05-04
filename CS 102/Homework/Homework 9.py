import csv

# returns data from a csv file without the header row in a 2d list
def read_in(filename):
    data = []
    with open(filename) as file:
        reader = csv.reader(file, delimiter=",")
        first = True
        for row in reader:
            if first:
                # ignore header row
                first = False
                continue
            data.append(row)
    return data

# prints each country's confirmed cases
def print_countries(data):
    if len(data) > 2:
        # first call/base case
        for entry in data:
            print_countries([entry[1], entry[5]])
    else:
        # recursive call, print the country and cases
        print(data[0], data[1])

# returns the total number of confirmed cases
def total_cases(data):
    total = 0
    if len(data) > 1:
        # first call/base case
        for entry in data:
            total += total_cases([entry[5]])
        return total
    else:
        # recursive call, return the number of cases
        return int(data[0])

# returns a dictionary with the keys being the countries and values being each country's death total
def combine_deaths(data, dictionary):
    if len(data) > 2:
        # first call/base case
        for entry in data:
            country = entry[1]
            deaths = combine_deaths([entry[6]], dictionary)
            # either create the key or append to it
            if country not in dictionary:
                dictionary[country] = deaths
            else:
                dictionary[country] += deaths
        return dictionary
    else:
        # recursive call, return number of deaths
        return int(data[0])

if __name__ == "__main__":
    print_countries(read_in(input()))

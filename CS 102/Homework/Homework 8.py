import csv

# return a list of each line in the given csv file
def get_csv_data(filename):
    with open(filename, 'r') as csvfile:
        rows = []
        for row in csv.reader(csvfile, delimiter=','):
            rows.append(row)
        # remove first row
        rows.pop(0)
    return rows

# adds up the value at the index in each line of the csv file
def get_data_total(filename, index):
    data = get_csv_data(filename)
    total = 0
    for entry in data:
        total += int(entry[index])
    return total

# prints out the first five lines of data in the csv file
def print_first_five(filename):
    # get the first five lines
    first_five = get_csv_data(filename)[0:5]
    # print and format to match expected output with no trailing comma
    for row in first_five:
        for i in range(len(row)):
            if i + 1 == len(row):
                print(row[i], end="")
            else:
                print(row[i], end=",")
        print()

# returns the total number of cases in the US
def total_cases(filename):
    # cases/infections is the eighth value in each line
    return get_data_total(filename, 7)

# returns the total number of deaths in the US
def total_deaths(filename):
    # deaths is the ninth value in each line
    return get_data_total(filename, 8)

# returns the total number of recovered patients in the US
def total_recovered(filename):
    # recovered is the tenth value in each line
    return get_data_total(filename, 9)

# returns the mortality rate in the US
def mortality_rate(filename):
    return 100 * (total_deaths(filename) / (total_cases(filename) + total_recovered(filename)))

# returns a dictionary that contains each state's number of cases
def total_infections_by_state(filename):
    data = get_csv_data(filename)
    infections = {}
    for entry in data:
        state = entry[2]
        cases = int(entry[7])
        if state in infections:
            # just add to the number of cases already (different county)
            infections[state] += cases
        else:
            # create the dictionary key for the state
            infections[state] = cases
    return infections

# returns the number of cases for the given state, or -1 if the state doesn't exist
def total_infections_for_state(filename, state):
    infections = total_infections_by_state(filename)
    if state in infections:
        return infections[state]
    else:
        # state doesn't exist or was misspelled
        return -1

if __name__ == "__main__":
    print_first_five(input())
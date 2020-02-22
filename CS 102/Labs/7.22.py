def steps_to_miles(steps):
    return steps / 2000

if __name__ == '__main__':
    print('{:.2f}'.format(steps_to_miles(int(input()))))

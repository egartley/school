def seconds_to_jiffies(seconds):
    return seconds * 100

if __name__ == '__main__':
    print('{:.2f}'.format(seconds_to_jiffies(int(input()))))

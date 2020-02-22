def swap_values(x, y):
    return (y, x)

if __name__ == '__main__':
    swapped = swap_values(int(input()), int(input()))
    print(swapped[0], swapped[1])

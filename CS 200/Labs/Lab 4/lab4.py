import wordladder


def main():
    infile = None
    try:
        infile = open('input.txt', 'r')
        for line in infile:
            pieces = line.split()
            start = pieces[0]
            end = pieces[1]

            ladder = wordladder.build_ladder(start, end)

            out = 'There is no word ladder between ' + start + ' and ' + end + '!' if ladder is None else str(ladder)
            print(out)
            with open("output.txt", "a") as file:
                file.write(out + "\n")

    except IOError:
        print('Wrong file name!')

    finally:
        if infile is not None:
            infile.close()


main()

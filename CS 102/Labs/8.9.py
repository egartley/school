text = input("Enter input string:")

while text != "q":
    if text.find(",") != -1:
        print()
    while text.find(",") == -1:
        print("\nError: No comma in string.\n")
        text = input("Enter input string:")
    text_split = text.split(",")
    first = text_split[0].strip()
    second = text_split[1].strip()
    print("First word:", first)
    print("Second word:", second)
    text = input("\nEnter input string:")
    if text == "q":
        print()

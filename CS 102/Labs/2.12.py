userInt = int(input("Enter integer (32 - 126):\n"))
userFloat = float(input("Enter float:\n"))
userChar = input("Enter character:\n")
userString = input("Enter string:\n")

print(userInt, userFloat, userChar, userString)
print(userString, userChar, userFloat, userInt)
print(userInt, "converted to a character is", chr(userInt))

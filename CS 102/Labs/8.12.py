text = input()
nospaces = text.replace(" ", "")
if nospaces[::-1] == nospaces:
    print(text, "is a palindrome")
else:
    print(text, "is not a palindrome")

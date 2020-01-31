key = {"i": "!", "a": "@", "m": "M", "B": "8", "o": "."}

word = input()
password = ""

for s in word:
    password += s if not(s in key) else key[s]
password += "q*s"

print(password)

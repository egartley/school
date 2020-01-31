user_text = input()
length = 0

for s in user_text:
    if s != " " and s != "." and s != ",":
        length += 1
        
print(length)

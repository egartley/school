embedded = input()
delimiter = input()

password = ""
# -1 to indicate they haven't been set
start = -1
end = -1

# go through each character in embedded
for index in range(len(embedded)):
    character = embedded[index]
    if character == delimiter:
        # current character is the delimiter, so start/end location needs to be set
        if start == -1:
            # start location hasn't been set, so set it to the next index
            start = index + 1
            # continue going through embedded to get the end location and actual password
            continue
        if end == -1:
            # end location hasn't been set, so set it to the previous index
            end = index - 1
            # stop going through embedded
            break
    
    if start != -1 and end == -1:
        # start was set, but not end, so add the current character to password
        password += character
        
if start == -1 or end == -1:
    # start/end was never set, meaning delimiter was only in embedded once or not at all
    print("No password found!")
else:
    print(start, end)
    print(password)

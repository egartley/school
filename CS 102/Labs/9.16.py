contacts = []
text = input().split(" ")
for i in range(0, len(text), 2):
    contacts.append([text[i], text[i + 1]])
name = input()
for contact in contacts:
    if contact[0] == name:
        print(contact[1])

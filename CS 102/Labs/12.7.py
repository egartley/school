def all_permutations(permList, nameList):
    if len(nameList) == 0:
        for name in permList:
            print(name, end=" ")
        print()
    else:
        for index in range(len(nameList)):
            name = nameList[index]
            permList.append(name)
            nameList.remove(name)
            all_permutations(permList, nameList)
            permList.pop()
            nameList.insert(index, name)

if __name__ == "__main__": 
    nameList = input().split(' ')
    permList = []
    all_permutations(permList, nameList)

weights = []
for i in range(4):
    weights.append(float(input("Enter weight " + str(i + 1) + ":\n")))
print("Weights:", weights)

total = 0
for weight in weights:
    total += weight
average = total / len(weights)
print("\nAverage weight: {:.2f}".format(average))

maximum = 0
for weight in weights:
    maximum = max(maximum, weight)
print("Max weight: {:.2f}".format(maximum))

index = int(input("\nEnter a list location (1 - 4):\n")) - 1
print("Weight in pounds: {:.2f}".format(weights[index]))
print("Weight in kilograms: {:.2f}".format(weights[index] / 2.2))

weights.sort()
print("\nSorted list:", weights)

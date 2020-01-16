age = int(input())
weight = float(input())
heartRate = float(input())
time = float(input())

print("Women: {:.2f} calories".format(((age * 0.074) - (weight * 0.05741) + (heartRate * 0.4472) - 20.4022) * time / 4.184))
print("Men: {:.2f} calories".format(((age * 0.2017) + (weight * 0.09036) + (heartRate * 0.6309) - 55.0969) * time / 4.184))

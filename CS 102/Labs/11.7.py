def get_age():
    age = int(input())
    if age < 18 or age > 75:
        raise ValueError("Invalid age.")
    return age

def fat_burning_heart_rate(age):
    return 0.7 * (220 - age)

if __name__ == "__main__":
    try:
        age = get_age()
        print("Fat burning heart rate for a", age, "year-old:", fat_burning_heart_rate(age), "bpm")
    except:
        print("Invalid age.")
        print("Could not calculate heart rate info.\n")

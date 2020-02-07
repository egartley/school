import math

def get_key():
    return int(input("Key: "))

def hash_multiplication(key, slots):
    return math.floor(slots * ((key * ((math.sqrt(5) - 1) / 2)) % 1))

if __name__ == "__main__":
    slots = int(input("Number of slots: "))
    key = get_key()
    while key >= 0:
        print("h({}) =".format(key), hash_multiplication(key, slots))
        key = get_key()

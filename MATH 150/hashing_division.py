import math

def get_key():
    return int(input("Key: "))

if __name__ == "__main__":
    slots = int(input("Number of slots: "))
    key = get_key()
    while key >= 0:
        print("h({}) =".format(key), key % slots)
        key = get_key()

import math
import hashing_multiplication

def get_key_string():
    return input("Key: ")

if __name__ == "__main__":
    slots = int(input("Number of slots: "))
    key = get_key_string()
    while key.lower() != "quit" and key.lower() != "exit":
        total = 0
        i = 0
        for p in range(len(key) - 1, -1, -1):
            total += ord(key[i]) * 128**p
            i += 1
        print("h(\"{}\") =".format(key), hashing_multiplication.hash_multiplication(total, slots))
        key = get_key_string()

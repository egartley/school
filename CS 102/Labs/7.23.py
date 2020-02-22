def integer_to_reverse_binary(num):
    reverse = ""
    while num > 0:
        reverse += str(num % 2)
        num //= 2
    return reverse
    
def reverse_string(s):
    return s[::-1]

if __name__ == '__main__':
    print(reverse_string(integer_to_reverse_binary(int(input()))))

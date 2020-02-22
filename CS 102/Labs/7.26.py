def is_list_even(my_list):
    for n in my_list:
        if n % 2 != 0:
            return False
    return True

def is_list_odd(my_list):
    for n in my_list:
        if n % 2 == 0:
            return False
    return True

if __name__ == '__main__':
    length = int(input())
    nums = []
    
    for i in range(length):
        nums.append(int(input()))
        
    if is_list_even(nums):
        print("all even")
    elif is_list_odd(nums):
        print("all odd")
    else:
        print("not even or odd")

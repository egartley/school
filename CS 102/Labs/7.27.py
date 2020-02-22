def get_user_values():
    length = int(input())
    nums = []
    
    for i in range(length):
        nums.append(int(input()))
        
    return nums, int(input())

def output_ints_less_than_or_equal_to_threshold(values, threshold):
    for num in values:
        if num <= threshold:
            print(num)

if __name__ == '__main__':
    user_values, upper_threshold = get_user_values()
    output_ints_less_than_or_equal_to_threshold(user_values, upper_threshold)

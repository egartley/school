amount = int(input())
nums = []

while len(nums) < amount:
    nums.append(int(input()))
    
threshold = int(input())

for num in nums:
    if num <= threshold:
        print(num)

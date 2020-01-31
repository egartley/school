amount = int(input())
nums = []

while len(nums) < amount:
    nums.append(int(input()))
    
minimum = min(nums)

for num in nums:
    print(num - minimum)

nums = input().split(" ")
for i in range(len(nums)):
    nums[i] = int(nums[i])

print("Too many inputs" if len(nums) > 9 else nums[len(nums) // 2])

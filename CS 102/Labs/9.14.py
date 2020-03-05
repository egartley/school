nums = input().split(" ")
for i in range(len(nums)):
    nums[i] = int(nums[i])

bounds = input().split(" ")
for num in nums:
    if num <= int(bounds[1]) and num >= int(bounds[0]):
        print(num, end=" ")

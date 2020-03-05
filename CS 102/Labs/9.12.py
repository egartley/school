nums = input().split(" ")
for i in range(len(nums)):
    nums[i] = int(nums[i])
filtered = []
for num in nums:
    filtered.append(num if num >= 0 else -1)
filtered.sort()
for num in filtered:
    print(num, end=" ")

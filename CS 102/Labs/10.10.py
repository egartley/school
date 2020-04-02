name = input()
lines = open(name).readlines()
shows = {}
shows_sorted = {}
shows_original = {}

for i in range(0, len(lines), 2):
    n = int(lines[i])
    if not(n in shows):
        shows[n] = lines[i + 1].strip()
    else:
        shows[n] += "; " + lines[i + 1].strip()
shows_original = shows
    
nums = list(shows.keys())
nums.sort()

for num in nums:
    shows_sorted[num] = shows[num]
shows = shows_sorted
        
output = open("output_keys.txt", "w")
for show in shows:
    output.write("{}: {}\n".format(str(show), shows[show]))
output.close()

titles = list(shows_original.values())
titles.sort()
output = open("output_titles.txt", "w")
for title in titles:
    output.write("{}\n".format(title))
output.close()

s = input()

indexA = 0
indexZ = len(s)

for i in range(indexZ):
	if s[i] == "A":
		indexA = i
		break

s = s[::-1]

for i in range(len(s)):
	if s[i] == "Z":
		indexZ = len(s)-i
		break

print(indexZ - indexA)
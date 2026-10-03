n = int(input())
d = list(map(int, input().split()))
c = [0, 0, 0]
for x in d:
	if x % 4 == 0:
		c[2] += 1
	elif x % 2 == 0:
		c[1] += 1
	else:
		c[0] += 1

# print(c)
if c[0] - 1 <= c[2] and c[1] == 0:
	print("Yes")
elif c[0] > c[2]:
	print("No")
else:
	print("Yes")

# 0 2 0 1
# 1 1 2 0 2 0 2 0 2 1 1
# 1 1 1 1  
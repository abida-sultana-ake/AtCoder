import re
S = input().split("+")
ans = 0
for elem in S:
	elem = elem.split("*")
	if not("0" in elem):
		ans += 1
print(ans)

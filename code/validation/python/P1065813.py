s = list(map(int, input().split()))

ab = s[0] * s[1]

cd = s[2] * s[3]

if ab >= cd:
	ans = ab
else:
	ans = cd

print(ans)

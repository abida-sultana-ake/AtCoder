a = map(int, raw_input().strip().split())
b = max(a[0],a[2])
c = min(a[1],a[3])
if c > b:
	ans = c-b
else:
	ans = 0
print(ans)
n = int(input())
a = [0] + list(map(int,input().split()))

le = 0
ans = 0
for i in range(1,n+1):
	if a[i-1] < a[i]:
		le += 1
	else:
		le = 1
	ans += le

print(ans)
	
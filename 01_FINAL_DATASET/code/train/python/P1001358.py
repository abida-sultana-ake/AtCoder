N = int(input())
a = list(map(int, input().split()))

ans = 0
l = 1
for i in range(1, N):
	if a[i-1] < a[i]:
		l += 1
	else:
		l = 1
	ans += l
	
print(int(ans) + 1)
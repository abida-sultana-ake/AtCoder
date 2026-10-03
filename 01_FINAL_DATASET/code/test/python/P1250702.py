N,T = map(int,input().split())
times = list(map(int,input().split()))
ans = T
t1 = 0
for t2 in times:
	t = t2 - t1
	t1 = t2
	ans = ans + min(t, T)
print(ans)
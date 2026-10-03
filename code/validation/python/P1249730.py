N, T = map(int, input().split())
t = [int(i) for i in input().split()]
ans = 0
s = 0
d = 0
for t_i in t:
	d = max(t_i + T - s, 0)
	ans += min(d, T)
	s = t_i + T
print(ans)
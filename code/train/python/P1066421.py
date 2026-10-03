n, a, b = map(int, input().split())
xi = list(map(int, input().split()))
ans = 0
 
for i in range(1, n):
	ans += (min(((xi[i] - xi[i-1])*a), b))
 
print(ans)
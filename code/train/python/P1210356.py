n, m = map(int, input().split())
mod = 10**9 + 7
X = [int(i) for i in input().split()]
Y = [int(i) for i in input().split()]
ans = 0
for i in range(n):
	ans += X[i]*(n-2*i-1)%mod
t = 0
for j in range(m):
	t += Y[j]*(m-2*j-1)%mod
ans *= t%mod
print(ans%mod)
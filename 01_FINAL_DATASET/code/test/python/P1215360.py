N, K = map(int, input().split())
A = [int(i) for i in input().split()]
ans = 0
for i in range(N):
	ans += min(i+1, K, N-i, N-K+1) * A[i]
print(ans)
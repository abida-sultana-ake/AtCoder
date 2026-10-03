N, A = map(int, input().split())
X = list(map(lambda x: int(x) - A, input().split()))
dp = [[0 for j in range(100 * N + 1)] for i in range(N+1)]
dp[0][50 * N] = 1
for i in range(N):
	for j in range(50, 100*N + 1-50):
		dp[i+1][j] = dp[i][j] + dp[i][j - X[i]]
print(dp[N][50 * N] -1)
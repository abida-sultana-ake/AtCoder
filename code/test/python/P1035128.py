N, A = map(int, input().split())
y = [int(i) - A for i in input().split()]
y = [0] + y
X = max(max(y) + A,A)
dp = []
for i in range(N+1):
	dp.append([])
	for j in range(2*N*X+1):
		if i == 0 and j == N*X:
			dp[i].append(1)
		elif i >= 1 and (j - y[i] < 0 or j - y[i] > 2*N*X):
			dp[i].append(dp[i-1][j])
		elif i >= 1 and 0 <= j - y[i] and j - y[i] <= 2*N*X:
			dp[i].append(dp[i-1][j]+dp[i-1][j-y[i]])
		else:
			dp[i].append(0)
print(dp[N][N*X]-1)
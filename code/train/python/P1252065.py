N, W = map(int, input().split())
ws = []
vs = []

for i in range(N):
	w, v = map(int, input().split())
	ws.append(w)
	vs.append(v)

w1 = ws[0]
s = 0

for i in range(N):
	ws[i] -= w1
	s += ws[i]

dp = [[[0]*(s+1) for i in range(N+1)] for k in range(N)]
for k in range(N):
	if (k+1)*w1 > W:
		break
	for i in range(1,N+1):
		for j in range(s+1):
			if j >= ws[i-1]:
				dp[k][i][j] = max(dp[k-1][i-1][j-ws[i-1]]+vs[i-1], dp[k][i-1][j])
			else:
				dp[k][i][j] = max(dp[k][i][j], dp[k][i-1][j])
			if j > 0:
				dp[k][i][j] = max(dp[k][i][j], dp[k][i][j-1])
ans = 0
for k in range(N):
	if W < (k+1)*w1:
		break
	ans = max(ans, dp[k][N][min(W-(k+1)*w1, s)])
print(ans)
from sys import stderr
print(dp, file=stderr)
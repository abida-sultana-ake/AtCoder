dp = [[0]*6000 for n in range(55)]

# dp[i][0]: -2500をつくれる

dp[0][2500]=1

N, A = [int(n) for n in input().split()]
X = [int(n) for n in input().split()]

for n, x in enumerate(X):
  t = x - A
  for i in range(6000):
    dp[n+1][i] = dp[n][i]
  for i in range(6000):
    if i+t < 6000 and i+t >= 0:
      dp[n+1][i+t] += dp[n][i]

print(dp[N][2500]-1)
N = int(input())
a = list(map(int, input().split())) + [0]
dp = [1000000001 for i in range(N + 1)]
dp[0] = 0
for i in range(0, N - 1):
  dp[i + 1] = min(dp[i + 1], dp[i] + abs(a[i] - a[i + 1]))
  dp[i + 2] = min(dp[i + 2], dp[i] + abs(a[i] - a[i + 2]))
print(dp[N - 1])

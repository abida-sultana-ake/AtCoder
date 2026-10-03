N = int(input())
h = list(map(int, input().split()))
h += [0] * 2
dp = [1000000000] * (N+2)
dp[0] = 0
for i in range(N):
    dp[i+1] = min(dp[i+1], dp[i] + abs(h[i]-h[i+1]))
    dp[i+2] = min(dp[i+2], dp[i] + abs(h[i]-h[i+2]))
print(dp[N-1])
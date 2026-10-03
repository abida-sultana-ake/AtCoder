N, Q = list(map(int, input().split()))

dp = [0] * (N + 2)

for i in range(Q):
    l, r = list(map(int, input().split()))
    dp[l] += 1
    dp[r + 1] += 1

c = 0
for i in range(1, N + 1):
    c += dp[i]
    dp[i] = c % 2

print(*dp[1:N + 1], sep='')
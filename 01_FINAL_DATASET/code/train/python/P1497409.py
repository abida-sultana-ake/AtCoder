N = int(input())
an = list(map(int , input().split()))
dp = [None] * N
dp[0] = 0
dp[1] = abs(an[0] - an[1])
for i in range(2, N):
    dp[i] = min(dp[i - 2] + abs(an[i] - an[i - 2]),
                dp[i - 1] + abs(an[i] - an[i - 1])) 
print(dp[-1])
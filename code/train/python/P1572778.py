n = int(input())
ng = [input()for _ in[None]*3]
dp = [float('inf')]*301
dp[n] = 0
for i in range(n,0,-1):
    if str(i)in ng:continue
    for j in range(1,4):
        dp[i-j] = min(dp[i]+1,dp[i-j])
if dp[0] > 100:
    print('NO')
else:
    print('YES')
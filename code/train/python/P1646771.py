r,c = map(int,input().split())
x,y = map(int,input().split())
d,l = map(int,input().split())
mod = 10**9+7

n = 30*30
dp = [[0]*(n+1) for _ in range(n+1)]
for i in range(n+1):
    dp[i][0] = dp[i][i] = 1
for i in range(2,n+1):
    for j in range(i):
        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%mod

if x*y == d+l:
    inwall = dp[x*y][d]
    print(inwall*(r-x+1)*(c-y+1)%mod)
else:
    pos = dp[x*y][d+l]
    if (x-1)*y >= d+l: pos -= dp[(x-1)*y][d+l]*2
    if x*(y-1) >= d+l: pos -= dp[x*(y-1)][d+l]*2

    if x*(y-2) >= d+l: pos += dp[x*(y-2)][d+l]
    if (x-2)*y >= d+l: pos += dp[(x-2)*y][d+l]
    if (x-1)*(y-1) >= d+l: pos += dp[(x-1)*(y-1)][d+l]*4

    if (x-1)*(y-2) >= d+l: pos -= dp[(x-1)*(y-2)][d+l]*2
    if (x-2)*(y-1) >= d+l: pos -= dp[(x-2)*(y-1)][d+l]*2

    if (x-2)*(y-2) >= d+l: pos += dp[(x-2)*(y-2)][d+l]

    while pos<0: pos += mod
    pos %= mod
    inwall = dp[d+l][d]
    print(((pos*inwall)%mod)*(r-x+1)*(c-y+1)%mod)

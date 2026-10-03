n,m = map(int,input().split())
sup = [int(input())-1 for _ in range(n)]
dp = [0]*(n+1)
dp[0] = 1
memo = [0]*m
lsteat = 0
psum = 1

for i in range(1,n+1):
    if lsteat < memo[sup[i-1]]:
        for j in range(lsteat,memo[sup[i-1]]):
            psum -= dp[j]
        lsteat = memo[sup[i-1]]
        if psum < 0: psum + 1000000007
    memo[sup[i-1]] = i
    dp[i] = psum
    psum = 2*psum%1000000007
print(dp[-1]%1000000007)

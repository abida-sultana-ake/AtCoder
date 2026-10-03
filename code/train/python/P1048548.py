MOD = 10**9+7
n = int(input())

dp = [1,0,0]
for i in range(64,-1,-1):
    ndp = [0,0,0]
    for d in range(3):
        nd = d*2 + (n>>i&1)
        ndp[min(2,nd)] += dp[d] # 0,0
        if nd >= 1: ndp[min(2,nd-1)] += dp[d] # 0,1
        if nd >= 2: ndp[min(2,nd-2)] += dp[d] # 1,1
    dp = ndp
    
print(sum(dp) % MOD)

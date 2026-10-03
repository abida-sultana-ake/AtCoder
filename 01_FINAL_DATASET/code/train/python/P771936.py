n=input()
a=map(int,raw_input().split())
dp=[float('inf')]*(n+1)
dp[0]=0
dp[1]=a[0]
for i in xrange(1,n):
    dp[i+1]=dp[i]+abs(a[i]-a[i-1])
    if i>=2:
        dp[i+1]=min(dp[i+1],dp[i-1]+abs(a[i]-a[i-2]))
print(dp[n]-a[0])

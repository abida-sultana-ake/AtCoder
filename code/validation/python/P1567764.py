from bisect import bisect_left
N = int(input())
a = [int(input()) for _ in [0]*N]
inf = float("inf")
dp = [inf]*(N+1)
dp[0] = 0

for n in a:
    dp[bisect_left(dp, n)] = n
    
print(N-len([n for n in dp if n != inf])+1)
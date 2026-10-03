import sys
sys.setrecursionlimit(1000000)
N = int(input())
a = tuple(int(n) for n in input().split())
dp = [None]*N
def getdp(n):
    if dp[n]:
        return dp[n]
    if n == N-1:
        return 0
    dp[n] = min(getdp(n+1) + abs(a[n]-a[n+1]), getdp(n+2) + abs(a[n]-a[n+2]) if n < N-2 else 100000000)

    return dp[n]

print(getdp(0))
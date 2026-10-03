import bisect

N = int(input())
P = []
for i in range(N):
    w, h = map(int, input().split())
    P.append((w, h))
P.sort(key=lambda x: (x[0], -x[1]))

INF = int(1e18)
dp = [INF for i in range(N)]
for i in range(N):
    ind = bisect.bisect_left(dp, P[i][1])
    dp[ind] = P[i][1]
res = bisect.bisect_left(dp, INF)
print(res)

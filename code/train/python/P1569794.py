import sys
sys.setrecursionlimit(10**8)

n, m = map(int, raw_input().split())
c = [0] * m
cost = [0] * m
idol = []
p = []
for i in xrange(m):
    c[i], cost[i] = map(int, raw_input().split())
    cost[i] = float(cost[i])
    idl = [0] * c[i]
    pb = [0] * c[i]
    for j in xrange(c[i]):
        idl[j], pb[j] = map(int, raw_input().split())
        idl[j] -= 1
        pb[j] = float(pb[j]) / 100.0
    idol.append(idl)
    p.append(pb)
dp = [float("inf")] * (1<<n)

def dfs(s):
    if s == (1<<n) - 1: return 0.0
    if dp[s] != float("inf"): return dp[s]
    for i in xrange(m):
        ev = 0.0
        same = 1.0
        cnt = 0
        for j in xrange(c[i]):
            nx = s | (1<<idol[i][j])
            if (nx == s):
                cnt += 1
                ev += cost[i] * p[i][j]
                same -= p[i][j]
            else:
                ev += (dfs(nx) + cost[i]) * p[i][j]
        if same == 0: continue
        if cnt == c[i]: continue
        dp[s] = min(dp[s], ev / same)
    return dp[s]

print("%.20f" % dfs(0))

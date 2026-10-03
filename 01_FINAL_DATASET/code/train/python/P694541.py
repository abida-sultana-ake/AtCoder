n = input()

g = [[] for _ in range(n)]

for i in range(n - 1):
    u, v = map(int, raw_input().split())
    g[u - 1].append(v - 1)
    g[v - 1].append(u - 1)

mod = 10 ** 9 + 7
dp0 = [0] * n
dp1 = [0] * n

def dfs(curr, prev):
    global mod, dp0, dp1, g
    dp0[curr] = 1
    dp1[curr] = 1
    
    for nxt in g[curr]:
        if nxt == prev: continue
        dfs(nxt, curr)
        dp0[curr] = dp0[curr] * (dp0[nxt] + dp1[nxt]) % mod
        dp1[curr] = dp1[curr] * dp0[nxt] % mod

dfs(0, -1)
print (dp0[0] + dp1[0]) % mod

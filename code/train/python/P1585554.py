import sys

stdin = sys.stdin

ni = lambda: int(ns())
na = lambda: list(map(int, stdin.readline().split()))
ns = lambda: stdin.readline()

n,m,r=na()
rs = na()
for i in range(r):
    rs[i] -= 1

g = [[99999999999]*n for _ in range(n)]
for i in range(n):
    g[i][i] = 0
for i in range(m):
    a, b, c = na()
    a -= 1
    b -= 1
    g[a][b] = g[b][a] = c

from heapq import *
def dijkstra(g, start):
    n = len(g)
    ds = [1e18] * n
    ds[start] = 0
    h = []
    heappush(h, (0, start))
    while len(h) > 0:
        d, cur = heappop(h)
        if d != ds[cur]: continue
        for e, ew in g[cur]:
            if d + ew < ds[e]:
                ds[e] = d + ew
                heappush(h, (ds[e], e))
    return ds

def dijkstra_dense(g, start):
    n = len(g)
    ds = [1e18] * n
    ds[start] = 0

    done = [0] * n
    while True:
        lmin = 1e19
        arg = -1
        for i in range(n):
            if not done[i] and ds[i] < lmin:
                lmin = ds[i]
                arg = i
        if arg == -1: break
        done[arg] = 1
        for i in range(n):
            ds[i] = min(ds[i], lmin + g[arg][i])
    return ds


dss = [None] * n
for r in rs:
    dss[r] = dijkstra_dense(g, r)

from itertools import *

ans = 9999999999999999999
for ord in permutations(rs):
    w = 0
    for i in range(1, len(rs)):
        w += dss[ord[i-1]][ord[i]]
    ans = min(ans, w)
print(ans)

import sys, math, itertools, collections, heapq

sys.setrecursionlimit(10 ** 7)
pinf = float("inf")
ninf = -float("inf")

n, m = map(int, input().split())
edge = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    edge[a - 1].append(b - 1)
    edge[b - 1].append(a - 1)

ans = "IMPOSSIBLE"
n -= 1
for e in edge[0]:
    if n in edge[e]:
        ans = "POSSIBLE"

print(ans)
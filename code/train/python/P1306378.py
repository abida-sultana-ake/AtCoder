import sys
sys.setrecursionlimit(10000)

n, m = map(int, input().split())
edges = [set() for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    edges[a - 1].add((b - 1, c))

NINF = float('-inf')
dists = [NINF for _ in range(n)]
dists[0] = 0


def trace(v, updated):
    updated[v] = True
    for b, c in edges[v]:
        if not updated[b]:
            trace(b, updated)


def bellman_ford():
    for i in range(n - 1):
        updated = False
        for j in range(n):
            dj = dists[j]
            if dj == NINF:
                continue
            for b, c in edges[j]:
                if dists[b] >= dj + c:
                    continue
                dists[b] = dj + c
                updated = True
        if not updated:
            return dists[-1]

    n_updated = [False] * n
    for j in range(n):
        if n_updated[j]:
            continue
        dj = dists[j]
        if dj == NINF:
            continue
        for b, c in edges[j]:
            if dists[b] < dj + c:
                trace(b, n_updated)

    return 'inf' if n_updated[-1] else dists[-1]


print(bellman_ford())

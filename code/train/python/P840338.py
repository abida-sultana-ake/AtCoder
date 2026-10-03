from operator import mul
from functools import reduce


def bfs():
    order = [0]
    visited = set([0])
    cursor = 0
    while cursor < n:
        for node in edges[order[cursor]]:
            if node not in visited:
                order.append(node)
                visited.add(node)
        cursor += 1
    return order


m = 1000000007
n = int(input())
edges = {i: [] for i in range(n)}
for _ in range(n-1):
    a, b = map(lambda x: int(x) - 1, input().split())
    edges[a].append(b)
    edges[b].append(a)
order = list(reversed(bfs()))
f = [1 for _ in range(n)]
g = [1 for _ in range(n)]
for i in order:
    g[i] = reduce(mul, [f[j] for j in edges[i]], 1)
    f[i] = g[i] + reduce(mul, [g[j] for j in edges[i]], 1)
print(f[0] % m)

import itertools
from heapq import heappop, heappush
N, M, R = map(int, input().split())
r = tuple(map(lambda n: int(n)-1, input().split()))
inf = float("inf")
edges = [[] for _ in [0]*N]
for _ in [0]*M:
    a, b, c = map(int, input().split())
    edges[a-1].append((b-1, c))
    edges[b-1].append((a-1, c))

vertices = [[inf]*N for _ in [0]*N]
for start in r:
    inf = float("inf")
    c_vs = vertices[start]
    c_vs[start] = 0
    q, rem = [(0, start)], N - 1

    while q and rem:
        cost, v = heappop(q)
        if c_vs[v] < cost:
            continue
        rem -= 1

        for dest, _cost in edges[v]:
            newcost = cost + _cost
            if c_vs[dest] > newcost:
                c_vs[dest] = newcost
                heappush(q, (newcost, dest))


ans = inf

for p in itertools.permutations(r):
    subt = 0
    for i in range(R-1):
        subt += vertices[p[i]][p[i+1]]
    if subt < ans:
        ans = subt

print(ans)
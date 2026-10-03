import sys
import heapq
readline = sys.stdin.readline

N, M = map(int, readline().split())
edges = [[] for _ in [None]*N]
for _ in [None]*M:
    a, b = map(int, readline().split())
    a, b = a-1, b-1
    edges[a].append((b, 1))
    edges[b].append((a, 1))


def dijkstra(n, edges, start):
    heappop, heappush = heapq.heappop, heapq.heappush
    inf = float("inf")
    vertices = [inf] * n
    vertices[start] = 0
    q, rem = [(0, start)], n - 1

    while q and rem:
        cost, v = heappop(q)
        if vertices[v] < cost:
            continue
        rem -= 1

        for dest, _cost in edges[v]:
            newcost = cost + _cost
            if vertices[dest] > newcost:
                vertices[dest] = newcost
                heappush(q, (newcost, dest))

    return vertices

print("POSSIBLE" if dijkstra(N, edges, 0)[N-1] == 2 else "IMPOSSIBLE")
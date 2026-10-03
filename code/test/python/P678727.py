import heapq
def dijkstra(edges, start):
    dist = [int(1e20)] * len(edges)
    heap = list()
    dist[start] = 0
    heapq.heappush(heap, (0, start))
    while len(heap) > 0:
        d, cur = heapq.heappop(heap)
        if dist[cur] == d:
            for ne, cost in edges[cur]:
                if d + cost < dist[ne]:
                    dist[ne] = d + cost
                    heapq.heappush(heap, (dist[ne], ne))
    return dist
n, m, t = map(int, input().split())
a = list(map(int, input().split()))
edges, rev = ([list() for _ in range(n)] for _ in range(2))
for _ in range(m):
    ai, bi, ci = map(int, input().split())
    edges[ai - 1].append((bi - 1, ci))
    rev[bi - 1].append((ai - 1, ci))
dist = [d1 + d2 for d1, d2 in zip(dijkstra(edges, 0), dijkstra(rev, 0))]
print(max(a[ni] * (t - dist[ni]) for ni in range(n)))
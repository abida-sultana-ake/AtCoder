from heapq import heappush, heappop

def Dijkstra(adj):
    dist = [float('inf') for i in range(len(adj))]
    dist[0] = 0
    que = []
    heappush(que, (0, 0))
    while len(que) != 0:
        cost, src = heappop(que)
        if dist[src] < cost:
            continue
        for to, ecost in adj[src]:
            if dist[to] > dist[src] + ecost:
                dist[to] = dist[src] + ecost
                heappush(que, (dist[to], to))
    return dist


N, M, T = map(int, input().split())
AA = [int(s) for s in input().split()]

graph = [[] for i in range(N)]
rgraph = [[] for i in range(N)]

for i in range(M):
    A, B, C = map(int, input().split())
    graph[A - 1].append((B - 1, C))
    rgraph[B - 1].append((A - 1, C))

X = Dijkstra(graph)
Y = Dijkstra(rgraph)

ret = 0
for i in range(N):
    ret = max(ret, (T - X[i] - Y[i]) * AA[i])

print(ret)

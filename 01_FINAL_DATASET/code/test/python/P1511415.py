import heapq
N = int(input())
es = [[] for i in range(N)]
for i in range(N-1):
    a,b,c = map(int,input().split())
    a,b = a-1, b-1
    es[a].append((b,c))
    es[b].append((a,c))
Q,K = map(int, input().split())
K -= 1

INF = float('inf')
ds = [INF for i in range(N)]
ds[K] = 0
visited = [0 for i in range(N)]
q = [K]
heapq.heapify(q)
while q:
    now = heapq.heappop(q)
    visited[now] = 1
    for to,cost in es[now]:
        ds[to] = min(ds[to], ds[now]+cost)
        if visited[to]: continue
        heapq.heappush(q,to)

for i in range(Q):
    x,y = map(int, input().split())
    x,y = x-1, y-1
    print(ds[x] + ds[y])

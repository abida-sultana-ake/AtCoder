from heapq import heappush, heappop
n = int(input())
G = [[] for i in range(n)]
for i in range(n-1):
    a, b, c = map(int, input().split())
    G[a-1].append((b-1, c))
    G[b-1].append((a-1, c))

q, k = map(int, input().split())

dist = [10**18]*n
que = [(0, k-1)]
dist[k-1] = 0
while que:
    cost, v = heappop(que)
    if dist[v] < cost:
        continue
    for t, c in G[v]:
        if cost + c < dist[t]:
            dist[t] = cost + c
            heappush(que, (cost + c, t))
ans = []
for i in range(q):
    x, y = map(int, input().split())
    ans.append("%d" % (dist[x-1] + dist[y-1]))
print("\n".join(ans))


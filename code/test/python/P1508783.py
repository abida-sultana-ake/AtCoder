from collections import deque

n = int(input())
gr = { i:[] for i in range(1, n + 1)}
for _ in range(n - 1):
    a, b, c = map(int, input().split())
    gr[a].append((b, c))
    gr[b].append((a, c))
q, k = map(int, input().split())
dmax = 10**14 + 1
dist = [dmax for _ in range(n + 1)]
dist[k] = 0
ls = deque([k])
while 0 < len(ls):
    u = ls.popleft()
    for v, c in gr[u]:
        if dist[v] == dmax:
            dist[v] = dist[u] + c
            ls.append(v)

for _ in range(q):
    x, y = map(int, input().split())
    print(dist[x] + dist[y])
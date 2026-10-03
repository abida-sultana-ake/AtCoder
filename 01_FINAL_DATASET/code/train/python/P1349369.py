import heapq
N = int(input())
a, b = map(int,input().split())
a, b = a-1, b-1
M = int(input())
sides = [[] for i in range(N)]
for i in range(M):
    x, y = map(int, input().split())
    sides[x-1].append(y-1)
    sides[y-1].append(x-1)

hpop, hpush = heapq.heappop, heapq.heappush
vertices = [10**9]*N
visited = [0]*N
vertices[a], visited[a] = 0, 1
q = [(0, a)]
while q:
    cost, pos = hpop(q)
    cost += 1
    for dist in sides[pos]:
        if vertices[dist] > cost:
            vertices[dist] = cost
            visited[dist] = 1
            hpush(q, (cost, dist))
    if all(visited):
        break

dp = [0]*N
dp[a] = 1
for c, v in sorted([(c, i) for i, c in enumerate(vertices)]):
    if c >= vertices[b]:
        break
    for dist in sides[v]:
        if vertices[dist] == c+1:
            dp[dist] += dp[v]

print(dp[b]%(10**9+7))
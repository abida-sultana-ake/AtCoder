import heapq as hq

N, M = map(int,input().split())

costs = dict()
adj = [list() for _ in range(N)]

e = lambda a,b: (a,b) if a<=b else (b,a)

for i in range(M):
  a,b,c = map(int, input().split())
  a -= 1
  b -= 1
  adj[a].append(b)
  adj[b].append(a)
  costs[e(a,b)] = c

max_dist = sum(costs.values())+1
used_edge = set()

for s in range(N):
  q = [(0,s)]
  dist = [max_dist]*N
  dist[s] = 0

  while q:
    c, u = hq.heappop(q)
    if c > dist[u]:
      continue

    for v in adj[u]:
      ee = e(u,v)
      if dist[v] > dist[u] + costs[ee]:
        dist[v] = dist[u] + costs[ee]
        hq.heappush(q, (dist[v], v))

  for t in adj[s]:
    if costs[e(s,t)] == dist[t]:
      used_edge.add(e(s,t))

print(len(costs.keys()-used_edge))

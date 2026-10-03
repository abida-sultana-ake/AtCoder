N,M = map(int, input().split())

import numpy as np

# adj matrix graph whose entry is length (empty edge is 0)
def warshal_floyd(adj_mat, n, inf):
  d = adj_mat.copy()
  d[d == 0] = inf
  for k in range(n):
    d = np.minimum(d, d[:,k,None]+d[None,k,:])
  return d

outgoing = dict()
adj_mat = np.zeros((N-1,N-1), dtype=int)

for i in range(M):
  u,v,l = map(int, input().split())
  u,v = u-2,v-2
  if u == -1:
    outgoing[v] = l
  else:
    adj_mat[u,v] = l
    adj_mat[v,u] = l


inf = np.sum(adj_mat)+1
d = warshal_floyd(adj_mat, N-1, inf)


cost = inf
neighbors = list(outgoing.keys())

for u in neighbors:
  for v in neighbors:
    if u != v:
      cost = min(cost, d[u,v] + outgoing[u] + outgoing[v])

if cost == inf:
  print(-1)
else:
  print(cost)
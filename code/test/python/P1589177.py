N,M = (int(i) for i in input().split()) 

import numpy as np
from scipy.sparse.csgraph import floyd_warshall


dist = np.zeros((N,N))

dist2 = np.zeros((N,1))


for _ in range(M):
  a,b,c = map(int,input().split())
  dist[a-1,b-1] = c


floyd_warshall(dist, directed=False, overwrite=True)

max = 0


for i in range(N):
    for j in range(N):
        if dist[i][j] > dist2[i][0]:
            dist2[i][0] = dist[i][j]
result = float('inf')

for i in range(N):
    if result > dist2[i][0]:
        result =  dist2[i][0]
        
print(int(result))
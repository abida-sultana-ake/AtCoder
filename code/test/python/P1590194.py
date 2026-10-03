import scipy.sparse.csgraph as ssc
import numpy as np

N,M = map(int,input().split())

G = np.zeros((N,N))
for _ in range(M):
  a,b,c = map(int,input().split())
  G[a-1,b-1] = c

ssc.floyd_warshall(G, directed=False, overwrite=True)

print(int(np.min(np.max(G,axis=1))))
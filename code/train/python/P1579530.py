N,M,NR = map(int,input().split())

R = list(map(lambda x: int(x) - 1 ,input().split()))

import scipy.sparse as ss
import numpy as np

G = ss.dok_matrix((N,N), dtype=np.uint32)

def it():
  for _ in range(M):
    a,b,c = map(int,input().split())
    a -= 1
    b -= 1
    yield ((a,b),c)
    yield ((b,a),c)

G.update(it())

D = ss.csgraph.floyd_warshall(G.tocsr(), directed=False)

def it2():
  from itertools import permutations
  for p in permutations(R):
    pp = iter(p)
    next(pp)
    yield sum(D[a,b] for a,b in zip(p,pp))

print(int(min(it2())))
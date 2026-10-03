import numpy as np
import scipy.sparse.csgraph as graph

N = int(input())
G = np.array([list(map(int, input().split())) for i in range(N)])

G2 = graph.floyd_warshall(G, directed=False)

if np.any(G != G2):
    print(-1)
    exit()
else:
    c = [2*10**9]*N
    d = np.diag(c)
    G += d
    ans = 0
    for i in range(N):
        for j in range(i+1, N):
            two = np.min(G[i]+G[j])
            if two != G[i,j]:
                ans += G[i,j]

print(ans)

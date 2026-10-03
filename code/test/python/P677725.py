from scipy.sparse import csr_matrix
from scipy.sparse.csgraph import dijkstra
from numpy import int64, inf
N, M, T = map(int, input().split())
A = [int(x) for x in input().split()]
fr, to, w = [], [], []
for _ in range(M):
    a, b, c = map(int, input().split())
    fr.append(a-1)
    to.append(b-1)
    w.append(c)
g, rg = csr_matrix((w, (fr, to)), shape=(N, N)), csr_matrix((w, (to, fr)), shape=(N, N))
d, rd = dijkstra(g, indices=0), dijkstra(rg, indices=0)
print(max(A[i] * max(0, T - int(d[i] + rd[i])) for i in range(N) if d[i] != inf and rd[i] != inf))

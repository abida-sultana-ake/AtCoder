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
graph = csr_matrix((w, (fr, to)), shape=(N, N), dtype=int64)
rev_graph = csr_matrix((w, (to, fr)), shape=(N, N), dtype=int64)
dist = dijkstra(graph, indices=0)
rev_dist = dijkstra(rev_graph, indices=0)
print(max(A[i] * max(0, T - int(dist[i] + rev_dist[i])) for i in range(N) if dist[i] != inf and rev_dist[i] != inf))

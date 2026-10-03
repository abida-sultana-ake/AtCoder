V, E = map(int, input().split())
edges = [set() for i in range(V)]
for i in range(E):
    a, b = map(int, input().split())
    edges[a-1].add(b-1)
    edges[b-1].add(a-1)

for i in range(V):
    print(len({_v for v in edges[i] for _v in edges[v] if not _v in edges[i] and _v != i}))
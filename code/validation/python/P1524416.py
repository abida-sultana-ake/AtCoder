import collections as col


n = int(input())
a = col.Counter(map(int, input().split()))

edges = []
for k, v in a.items():
    if v >= 4:
        edges.extend((k, k))
    elif v >= 2:
        edges.append(k)

edges.sort(reverse=True)

if len(edges) >= 2:
    print(edges[0]*edges[1])
else:
    print(0)

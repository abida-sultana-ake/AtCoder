n,x = map(int,input().split())
x -= 1
h = list(map(int, input().split()))
edge = [[] for i in range(n)]
#child = [[] for i in range(n)]
parent = [x for i in range(n)]
for i in range(n-1):
    a,b = map(int,input().split())
    a -= 1
    b -= 1
    edge[a].append(b)
    edge[b].append(a)

search = [x]
rest = [i for i in range(n)]
rest.remove(x)
while len(search) > 0:
    node = search[0]
    search.pop(0)
    e = edge[node]
    for v in e:
        if v in rest:
            parent[v] = node
            search.append(v)
            rest.remove(v)
path = []
for i in range(n):
    if h[i] == 0 or i == x:
        continue
    v = i
    while parent[v] != x:
        path.append((v,parent[v]))
        v = parent[v]
    path.append((v,parent[v]))

path = list(set(path))

print(len(path) * 2)
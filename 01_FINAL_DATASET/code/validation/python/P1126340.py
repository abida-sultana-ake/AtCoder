def find(x):
    if par[x] == x:
        return x
    else:
        par[x] = find(par[x])
        return par[x]

def unite(x, y):
    x = find(x)
    y = find(y)
    if x == y:
        return

    if rank[x] < rank[y]:
        par[x] = y
    else:
        par[y] = x
        if rank[x] == rank[y]:
            rank[x] += 1

def same(x, y):
    return find(x) == find(y)

N, M = map(int, input().split())
par = [i for i in range(N)]
rank = [0 for i in range(N)]
for i in range(M):
    a, b = map(int, input().split())
    unite(a-1, b-1)

s = set([])
for i in range(N):
    s.add(find(i))

print(len(s)-1)

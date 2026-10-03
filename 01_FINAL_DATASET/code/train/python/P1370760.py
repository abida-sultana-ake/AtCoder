N, K, L = map(int, input().split())

def get_root(l, a):
    if l[a] == a:
        return a
    else:
        l[a] = get_root(l, l[a])
        return l[a]

def unite(l, a, b):
    _a, _b = get_root(l, a), get_root(l, b)
    if _a != _b:
        if a < b:
            l[_b] = _a
        else:
            l[_a] = _b

road = [i for i in range(N)]
for i in range(K):
    p, q = map(int, input().split())
    unite(road, p-1, q-1)

rail = [i for i in range(N)]
for i in range(L):
    r, s = map(int, input().split())
    unite(rail, r-1, s-1)

result = {}
for i in range(N):
    p = (get_root(road,i), get_root(rail,i))
    if p in result:
        result[p] += 1
    else:
        result[p] = 1


print(" ".join([str(result[(get_root(road, i), get_root(rail, i))]) for i in range(N)]))
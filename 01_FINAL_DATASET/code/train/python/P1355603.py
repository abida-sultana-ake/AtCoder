V, E = map(int, input().split())
roads = sorted([(y, a-1, b-1) for i in range(E) for a, b, y in [map(int, input().split())]])
unyontree = [-1]*V
Q = int(input())
queries = sorted([(y, v-1, i) for i in range(Q) for v, y in [map(int, input().split())]])
ans = [None]*Q

def get_root(n):
    if unyontree[n] < 0:
        return n
    else:
        unyontree[n] = get_root(unyontree[n])
        return unyontree[n]

def unite(a, b):
    a, b = get_root(a), get_root(b)
    if a != b:
        if unyontree[a] < unyontree[b]:
            unyontree[a] += unyontree[b]
            unyontree[b] = a
        else:
            unyontree[b] += unyontree[a]
            unyontree[a] = b

year = 99999999
while roads:
    y, a, b = roads.pop()
    year = y
    while queries and queries[-1][0] >= year:
        y, v, i = queries.pop()
        ans[i] = unyontree[get_root(v)] * -1
    unite(a, b)

while queries:
    y, v, i = queries.pop()
    ans[i] = unyontree[get_root(v)] * -1

print("\n".join((str(n) for n in ans)))
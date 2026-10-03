import itertools

s = input()
l = s.split()
N = int(l[0])
M = int(l[1])

a = list()
b = list()
edges = set()
for i in range(1, M + 1):
    s = input()
    l = s.split()
    u = int(l[0])
    v = int(l[1])
    a.append(u)
    b.append(v)
    edges.add((u, v))
    edges.add((v, u))
#print(edges)

t = range(1, N + 1)
res = 0
for p in itertools.permutations(t):
    if p[0] != 1:
        break
    c = 0
    for j in range(0, N - 1):
        if (p[j], p[j + 1]) in edges:
            c += 1
    if c == N - 1:
        res += 1
print(res)
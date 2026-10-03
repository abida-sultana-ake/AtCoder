import sys
from collections import Counter

class UnionFind:

    def __init__(self, n):
        self.p = list(range(n))
        self.rank = [0] * n

    def find_root(self, x):
        if x != self.p[x]:
            self.p[x] = self.find_root(self.p[x])

        return self.p[x]

    def is_same(self, x, y):
        return self.find_root(x) == self.find_root(y)

    def unite(self, x, y):
        u = self.find_root(x)
        v = self.find_root(y)

        if u == v:
            return

        if self.rank[u] < self.rank[v]:
            self.p[u] = v
        else:
            self.p[v] = u

            if self.rank[u] == self.rank[v]:
                self.rank[u] += 1


N, K, L = map(int, sys.stdin.readline().split())

uf1 = UnionFind(N)
uf2 = UnionFind(N)

for i in range(K):
    p, q = map(int, sys.stdin.readline().split())
    p, q = p - 1, q - 1
    uf1.unite(p, q)

for i in range(L):
    r, s = map(int, sys.stdin.readline().split())
    r, s = r - 1, s - 1
    uf2.unite(r, s)

cntr = Counter()

for i in range(N):
    u = uf1.find_root(i)
    v = uf2.find_root(i)

    cntr[(u, v)] += 1

ans = []

for i in range(N):
    u = uf1.find_root(i)
    v = uf2.find_root(i)

    ans.append(cntr[(u, v)])

print(*ans)
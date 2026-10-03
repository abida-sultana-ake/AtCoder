from collections import defaultdict


class UF:
    def __init__(self, _n):
        assert _n >= 0
        self._count = _n
        self._parent = list(range(_n))
        self._rank = [1] * _n

    def find(self, p):
        assert p >= 0 & p < len(self._parent)
        while p != self._parent[p]:
            self._parent[p] = self._parent[self._parent[p]]    # path compression by halving
            p = self._parent[p]
        return p

    def count(self):
        return self._count

    def connected(self, p, q):
        return self.find(p) == self.find(q)

    def union(self, p, q):
        root_p = self.find(p)
        root_q = self.find(q)
        if root_p == root_q:
            return
        
        if self._rank[root_p] < self._rank[root_q]:
            self._parent[root_p] = root_q
        elif self._rank[root_p] > self._rank[root_q]:
            self._parent[root_q] = root_p
        else:
            self._parent[root_q] = root_p
            self._rank[root_p] += 1
        self._count -= 1


n, k, l = map(int, input().split())
uf_road, uf_rail = UF(n), UF(n)

for _ in range(k):
    p, q = map(int, input().split())
    uf_road.union(p-1, q-1)

for _ in range(l):
    p, q = map(int, input().split())
    uf_rail.union(p-1, q-1)

d = defaultdict(int)
for i in range(n):
    d[uf_road.find(i), uf_rail.find(i)] += 1
#print(d)
#print(' '.join(str(d[(uf_road.find(i), uf_rail.find(i))]) for i in range(n)))
print(*(d[uf_road.find(i), uf_rail.find(i)] for i in range(n)))
import sys

class UnionFind:
    def __init__(self, size):
        self.ranks   = [1] * size
        self.sizes   = [1] * size
        self.parents = [ i for i in range(size) ]

    def find(self, x):
        if x == self.parents[x]:
            return x
        else:
            self.parents[x] = self.find(self.parents[x])
            return self.parents[x]

    def same(self, x, y):
        return self.find(x) == self.find(y)

    def unite(self, x, y):
        px = self.find(x)
        py = self.find(y)
        if px == py:
            return
        if self.ranks[px] > self.ranks[py]:
            self.parents[py] = px
            self.sizes[px] += self.sizes[py]
        else:
            self.parents[px] = py
            self.sizes[py] += self.sizes[px]
            if self.ranks[px] == self.ranks[py]:
                self.ranks[py] += 1

#####

n,m = map(int,input().split())

edges = []
for i in range(m):
    a, b, y = map(int, sys.stdin.readline().split())
    edges.append( (a,b,y) )
edges = sorted(edges, key=lambda x: x[2], reverse=True)

uf = UnionFind(n + 1) # 1-base

persons = []
q = int(input())
for i in range(q):
    v, w = map(int, sys.stdin.readline().split())
    persons.append( (i,v,w) )

persons = sorted(persons, key=lambda x: x[2], reverse=True)

ans = []
j = 0
for p in persons:
    i, v, w = p
    while j < len(edges) and edges[j][2] > w:
        uf.unite(edges[j][0], edges[j][1])
        j += 1
    ans.append( (i,uf.sizes[uf.find(v)]) )

for p in sorted(ans, key=lambda x: x[0]):
    print(p[1])


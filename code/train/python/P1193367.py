from sys import stdin
from operator import itemgetter

def solve():
    N, M = map(int, stdin.readline().split())
    douros = [[int(i) for i in stdin.readline().split()] for j in range(M)]
    Q = int(stdin.readline())
    persons = [[int(i) for i in stdin.readline().split()] + [j] for j in range(Q)]

    douros.sort(key=itemgetter(2), reverse=True)
    persons.sort(key=itemgetter(1), reverse=True)

    left = 0
    uf = UnionFind(N)
    ans = [0] * Q

    for v, w, j in persons:
        for i in range(left, M):
            a, b, y = douros[i]

            if y <= w:
                left = i
                break

            uf.unite(a - 1, b - 1)
        else:
            left = M

        ans[j] = uf.get_size(v - 1)

    print(*ans, sep='\n')

class UnionFind:
    def __init__(self, N):
        self.p = list(range(N))
        self.rank = [0] * N
        self.size = [1] * N

    def find_root(self, x):
        if self.p[x] != x:
            self.p[x] = self.find_root(self.p[x])

        return self.p[x]

    def same(self, x, y):
        return self.find_root(x) == self.find_root(y)

    def unite(self, x, y):
        u = self.find_root(x)
        v = self.find_root(y)

        if u == v: return

        if self.rank[u] < self.rank[v]:
            self.p[u] = v
            self.size[v] += self.size[u]
            self.size[u] = 0
        else:
            self.p[v] = u
            self.size[u] += self.size[v]
            self.size[v] = 0

            if self.rank[u] == self.rank[v]:
                self.rank[u] += 1

    def get_size(self, x):
        return self.size[self.find_root(x)]

if __name__ == '__main__':
    solve()
from collections import Counter
import sys

sys.setrecursionlimit(10 ** 5 + 1)


class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))

    def is_same_set(self, x: int, y: int) -> bool:
        return self.find_root(x) == self.find_root(y)

    def union_set(self, x: int, y: int):
        x = self.find_root(x)
        y = self.find_root(y)
        if x == y:
            return

        self.parent[x] = y

    def find_root(self, x: int):
        if self.parent[x] == x:
            return x
        else:
            self.parent[x] = self.find_root(self.parent[x])
            return self.parent[x]


def main():
    N, K, L = map(int, input().split())
    uf1 = UnionFind(N)
    for _ in range(K):
        p, q = map(int, input().split())
        p -= 1
        q -= 1
        uf1.union_set(p, q)

    uf2 = UnionFind(N)
    for _ in range(L):
        r, s = map(int, input().split())
        r -= 1
        s -= 1
        uf2.union_set(r, s)

    groups = [(uf1.find_root(i), uf2.find_root(i)) for i in range(N)]
    c = Counter(groups)

    print(*(c[g] for g in groups))


if __name__ == '__main__':
    main()
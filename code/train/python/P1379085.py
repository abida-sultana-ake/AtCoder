# coding: utf-8
import array, bisect, collections, copy, heapq, itertools, math, random, re, string, sys, time

sys.setrecursionlimit(10 ** 7)
INF = 10 ** 20
MOD = 10 ** 9 + 7


def II(): return int(input())
def ILI(): return list(map(int, input().split()))
def IAI(LINE): return [ILI() for __ in range(LINE)]
def IDI(): return {key: value for key, value in ILI()}


def read():
    N = II()
    x, y = [], []
    for i in range(N):
        _x, _y = ILI()
        x.append((i, _x))
        y.append((i, _y))
    return N, x, y


class UnionFind(object):
    def __init__(self, number_of_nodes):  # 初期化
        self.par = array.array("L", range(number_of_nodes))
        self.rank = array.array("L", (0 for i in range(number_of_nodes)))

    def root(self, node):  # 根を求める
        if self.par[node] == node:
            return node
        else:
            r = self.root(self.par[node])
            self.par[node] = r  # 経路圧縮
            return r

    def in_the_same_set(self, node1, node2):  # 同じ集合に属するか
        return self.root(node1) == self.root(node2)

    def unite(self, node1, node2):  # 属する集合を併合
        x = self.root(node1)
        y = self.root(node2)
        if x == y:
            pass
        elif self.rank[x] < self.rank[y]:
            self.par[x] = y
        else:
            self.par[y] = x
            if self.rank[x] == self.rank[y]:
                self.rank[x] += 1


def solve(N, x, y):
    edges = []
    x.sort(key=lambda x: x[1])
    y.sort(key=lambda x: x[1])
    for i in range(N - 1):
        x_s, x_e = x[i], x[i + 1]
        y_s, y_e = y[i], y[i + 1]
        edges.append((x_s[0], x_e[0], x_e[1] - x_s[1]))
        edges.append((y_s[0], y_e[0], y_e[1] - y_s[1]))

    edges.sort(key=lambda x: x[2])
    union_find = UnionFind(N)
    ans = 0
    for edge in edges:
        if not union_find.in_the_same_set(edge[0], edge[1]):
            union_find.unite(edge[0], edge[1])
            ans += edge[2]

    return ans


def main():
    params = read()
    print(solve(*params))


if __name__ == "__main__":
    main()

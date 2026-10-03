import operator
import sys

# sys.stdin = open('d1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_str_list():
    return input().split()


def read_int():
    return int(input())


def read_str():
    return input()


p = []
rank = []


def make_set(x):
    p[x] = x
    rank[x] = 0


def _union(x, y):
    link(find_set(x), find_set(y))


def link(x, y):
    if rank[x] > rank[y]:
        p[y] = x
    else:
        p[x] = y
        if rank[x] == rank[y]:
            rank[x] += 1


def find_set(x):
    if x != p[x]:
        p[x] = find_set(p[x])
    return p[x]


def solve():
    n = read_int()
    a = [read_int_list() for i in range(n)]
    global p, rank
    p = [0] * n
    rank = [0] * n

    for x in range(n):
        make_set(x)

    def get_cost(i, j):
        return min(abs(a[i][0] - a[j][0]), abs(a[i][1] - a[j][1]))

    roads = []
    for j in range(2):
        l = sorted(range(n), key=lambda i: a[i][j])
        for i in range(n - 1):
            cost = get_cost(l[i], l[i + 1])
            road = (cost, l[i], l[i + 1])
            roads.append(road)
    roads.sort()

    res = 0
    for road in roads:
        c, u, v = road
        if find_set(u) != find_set(v):
            res += c
            _union(u, v)
    return res


def main():
    res = solve()
    print(res)


main()

import operator
import sys
import heapq

# sys.stdin = open('b1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_int():
    return int(input())


def read_str_list():
    return input().split()


def read_str():
    return input()


def link(x, y):
    if rank[x] > rank[y]:
        p[y] = x
    else:
        p[x] = y
        if rank[x] == rank[y]:
            rank[y] = rank[x] + 1


def _union(x, y):
    link(find_set(x), find_set(y))


def find_set(x):
    if x != p[x]:
        p[x] = find_set(p[x])
    return p[x]


def dist(j, k):
    return min(abs(pairs[j][0] - pairs[k][0]), abs(pairs[j][1] - pairs[k][1]))


n = read_int()
pairs = [read_int_list() for i in range(n)]

p = list(range(n))
rank = [0] * n

edges = []

for pos in range(2):
    indices = list(range(n))
    indices.sort(key=lambda u: pairs[u][pos])
    for i in range(1, n):
        j = indices[i - 1]
        k = indices[i]
        w = dist(j, k)
        heapq.heappush(edges, (w, j, k))

res = 0
while edges:
    edge = heapq.heappop(edges)
    w, j, k = edge
    if find_set(j) != find_set(k):
        res += w
        _union(j, k)

print(res)

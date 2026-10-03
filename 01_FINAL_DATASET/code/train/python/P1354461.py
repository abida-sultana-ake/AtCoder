import sys

# sys.stdin = open('b1.in')

n, m = map(int, input().split())

roads = []
for i in range(m):
    a, b = map(int, input().split())
    roads.append((a, b))

res = [0] * n
for a, b in roads:
    res[b - 1] += 1
    res[a - 1] += 1
for r in res:
    print(r)

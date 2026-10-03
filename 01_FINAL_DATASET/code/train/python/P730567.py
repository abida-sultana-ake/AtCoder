from collections import *
Magic = namedtuple('Magic', ['a','b'])

n = int(input())
magics = [Magic(*map(int, input().split())) for _ in range(n)]

downs = list(filter(lambda x: x.a-x.b <= 0, magics))
downs.sort(key=lambda x: x.a)
ups = list(filter(lambda x: not x.a-x.b <= 0, magics))
ups.sort(key=lambda x: x.b, reverse=True)

l = downs + ups
edges = [l[0].a]
for i in range(n-1):
    edges.append(edges[i] - l[i].b + l[i+1].a)
print(max(edges))

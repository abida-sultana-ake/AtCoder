import sys
sys.setrecursionlimit(1000000)

N = int(input())

P = [n for n in range(N)]
points = []

def root(a):
  if P[a] == a:
    return a
  P[a] = root(P[a])
  return P[a]

def is_same_set(a, b):
  return root(a) == root(b)

def unite(a, b):
  P[root(a)] = root(b)


for i in range(N):
  x, y = [int(n) for n in input().split()]
  points.append((i, x, y))

xs = sorted([(x, i) for i, x, y in points], key=lambda p: p[0])
xedges = [(xs[n][1], xs[n+1][1], xs[n+1][0]-xs[n][0] ) for n in range(N-1)]
ys = sorted([(y, i) for i, x, y in points], key=lambda p:p[0])
yedges = [(ys[n][1], ys[n+1][1], ys[n+1][0]-ys[n][0]) for n in range(N-1)]

edges = xedges + yedges
edges.sort(key=lambda x: x[2])
res = 0
for edge in edges:
  i, j, cost = edge
  if not is_same_set(i, j):
    unite(i, j)
    res += cost

print(res)
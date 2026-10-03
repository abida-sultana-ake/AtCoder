import sys

# sys.stdin = open('d1.in')

n, W = map(int, input().split())
g = {}
w1 = 0
for i in range(n):
    w, v = map(int, input().split())
    if i == 0:
        w1 = w
        for x in range(w, w + 4):
            g[x] = []
    g[w].append(v)
for w, values in g.items():
    values.sort(reverse=True)

res = 0
for a in range(len(g[w1]) + 1):
    for b in range(len(g[w1 + 1]) + 1):
        for c in range(len(g[w1 + 2]) + 1):
            for d in range(len(g[w1 + 3]) + 1):
                total_w = w1 * a + (w1 + 1) * b + (w1 + 2) * c + (w1 + 3) * d
                if total_w > W:
                    continue

                total_v = 0
                for i in range(a):
                    total_v += g[w1][i]
                for i in range(b):
                    total_v += g[w1 + 1][i]
                for i in range(c):
                    total_v += g[w1 + 2][i]
                for i in range(d):
                    total_v += g[w1 + 3][i]
                if total_v > res:
                    res = total_v
print(res)

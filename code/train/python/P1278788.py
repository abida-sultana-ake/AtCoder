n, m = map(int, input().split())
f = [0] * (n + 2)
for i in range(m):
    x, y = map(int, input().split())
    f[x] += 1
    f[y] += 1
for i in range(1, n + 1):
    print(f[i])
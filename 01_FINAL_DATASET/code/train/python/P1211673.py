def read(): return list(map(int, input().split()))

n, m = read()
x = read()
y = read()

xs, ys = 0, 0
xs = sum([x[i] * (2 * i + 1 - n) for i in range(n)])
ys = sum([y[i] * (2 * i + 1 - m) for i in range(m)])

print((xs * ys) % 1000000007)
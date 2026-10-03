def read(): return list(map(int, input().split()))


MOD = 10 ** 9 + 7
n, m = read()
x = read()
y = read()

xs, ys = 0, 0
for i in range(n):
    xs += x[i] * (2 * i + 1 - n)
    xs %= MOD

for i in range(m):
    ys += y[i] * (2 * i + 1 - m)
    ys %= MOD

print((xs * ys) % MOD)
n, m = map(int, input().split())
x = list(map(int, input().split()))
y = list(map(int, input().split()))
mod = 10 ** 9 + 7
xsum = sum((i * x[i] - (n - 1 - i) * x[i]) for i in range(n))
ysum = sum((i * y[i] - (m - 1 - i) * y[i]) for i in range(m))
ans = (xsum * ysum) % mod
print(ans)

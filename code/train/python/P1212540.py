n, m = map(int, input().split())

xs = list(map(int, input().split()))
ys = list(map(int, input().split()))

MOD = int(1e9 + 7)

x_sum = 0
y_sum = 0

for k in range(1, n+1):
    #x_sum += ((k-1) * xs[k-1] - (n-k) * xs[k-1])
    x_sum += ((2*k-n-1) * xs[k-1]) % MOD

for k in range(1, m+1):
    y_sum += (2*k-m-1) * ys[k-1] % MOD

print(x_sum * y_sum % MOD)
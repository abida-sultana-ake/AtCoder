MOD = 10 ** 9 + 7
N, M = map(int, input().split())
X = list(map(int, input().split()))
Y = list(map(int, input().split()))

x_sum = 0
for i in range(N):
    x_sum = (x_sum + X[i] * (N - i - 1) - X[i] * i) % MOD

y_sum = 0
for i in range(M):
    y_sum = (y_sum + Y[i] * (M - i - 1) - Y[i] * i) % MOD

result = (x_sum * y_sum) % MOD

print(result)

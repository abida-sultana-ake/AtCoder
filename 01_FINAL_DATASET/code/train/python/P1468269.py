K = int(input())

N = 50
a = [0] * N

m = K // N
mod = K % N

for i in range(0, mod):
    a[i] = N * (m + 2) - K + m

for i in range(mod, N):
    if m != 0:
        a[i] = N * (m + 1) - K + m - 1

print(N)
print(' '.join([str(x) for x in a]))
N, Q = map(int, input().split())
L = [0] * Q
R = [0] * Q
T = [0] * Q
a = [0] * N
for i in range(Q):
    L[i], R[i], T[i] = map(int, input().split())

for i in range(Q):
    for j in range(L[i] - 1, R[i]):
        a[j] = T[i]

for i in range(N):
    print(a[i])

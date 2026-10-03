N, Q = list(map(int, input().split()))
A = [0] * N
for i in range(Q):
    L, R, T = list(map(int, input().split()))
    for j in range(L - 1, R):
        A[j] = T
for i in A : print(i)

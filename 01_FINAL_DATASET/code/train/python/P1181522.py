N, M = map(int, input().split())
A, B = [], []
for i in range(N):
    a, b = map(int, input().split())
    A.append(a)
    B.append(b)

C, D = [], []
for i in range(M):
    c, d = map(int, input().split())
    C.append(c)
    D.append(d)

for a, b in zip(A, B):
    best = 1<<30
    res = None
    for i in range(M):
        d = abs(a - C[i]) + abs(b - D[i])
        if res is None or best > d:
            best = d
            res = i
    print(res + 1)
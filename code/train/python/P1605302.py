import numpy as np
N = int(input())
A = [np.array(input().split(), dtype=np.int64) for _ in [0]*N]
inf = 10**10
for i in range(N):
    A[i][i] = inf

result = 0
for i in range(N-1):
    for j, d1 in enumerate(A[i][i+1:], start=i+1):
        d2 = np.min(A[i]+A[j])
        if d1 >= d2:
            if d1 > d2:
                print(-1)
                exit()
        else:
            result += d1
print(result)
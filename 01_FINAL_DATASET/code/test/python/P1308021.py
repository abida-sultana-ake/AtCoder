from heapq import *

N = int(input())
a = list(map(int,input().split()))

sumS1 = [0 for i in range(N + 1)]
S1 = a[0:N]
heapify(S1)
sumS1[0] = sum(S1)

for k in range(1, N + 1):
    if S1[0] < a[N + k - 1]:
        sumS1[k] = sumS1[k - 1] +a[N + k - 1] - S1[0]
        heapreplace(S1, a[N + k - 1])
    else:
        sumS1[k] = sumS1[k - 1]

sumS2 = [0 for i in range(N + 1)]
S2 =  [-1 * i for i in a[2 * N:3 * N]]
heapify(S2)
sumS2[N] = sum(S2)

for k in range(1, N + 1):
    if S2[0] < -1 * a[2 * N - k]:
        sumS2[N - k] = sumS2[N - k + 1] - a[2 * N - k] - S2[0]
        heapreplace(S2, -1 * a[2 * N - k])
    else:
        sumS2[N - k] = sumS2[N - k + 1]


res = [float("-inf")] * (N + 1)
for i in range(N + 1):
    res[i] = sumS1[i] + sumS2[i]

res.sort()
print(res[N])
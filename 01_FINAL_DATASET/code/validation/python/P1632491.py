import bisect
N = int(input())
c = [int(input()) for _ in range(N)]
LIS = [c[0]]
for i in range(1,N):
    if c[i] > LIS[-1]:
        LIS.append(c[i])
    else:
        idx = bisect.bisect(LIS,c[i])
        LIS[idx] = min(LIS[idx], c[i])
print(N - len(LIS))
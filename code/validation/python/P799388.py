import sys
A, K = map(int, input().split())

def pow(b, e):
    if e == 0:  return 1
    elif e % 2 == 0:
        return pow(b*b, e//2)
    else:
        return b * pow(b*b, (e-1)//2)

M = 2 * 10**12
if A >= M:
    print(0)
    sys.exit(0)
elif K == 0:
    print(M-A)
    sys.exit(0)
lo = 0
hi = 1

def calc(n):
    return pow(K+1, n) * (A + 1/K) - (1/K)

while calc(hi) < M: hi <<= 1
for i in range(200):
    mid = (hi+lo)//2
    if calc(mid) < M:   lo = mid
    else:   hi = mid

print(hi)

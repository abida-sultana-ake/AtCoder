import math

N = int(input())
ret = float('inf')
i = 1

while i * i <= N:
    if N % i == 0:
        ret = min(ret, int(max(math.log10(i), math.log10(N/i))) + 1)
    i += 1

print(ret)
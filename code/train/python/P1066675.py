import sys
import math

N, A, B = map(int, input().split())
X = [int(x) for x in input().split()]

ans = 0

for i in range(N - 1):
    ans += min(A * (X[i + 1] - X[i]), B)

print(ans)
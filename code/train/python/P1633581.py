import math

N = int(input())
ret = 0
R = sorted([int(input()) for _ in range(N)])
for r in R:
    ret = r ** 2 * math.pi - ret
print(abs(ret))

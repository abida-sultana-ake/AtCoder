import math
n = int(input())

rs = list(reversed(sorted(([int(input()) for i in range(n)]))))

s = 0
oddy = len(rs) % 2
for i, r in enumerate(rs):
    if i % 2 != oddy:
        s += r * r
    else:
        s -= r * r

print(abs(s * math.pi))

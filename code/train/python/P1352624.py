import math
import sys

# sys.stdin = open("d1.in")

N, A, B = [int(_) for _ in input().split()]
H = sorted([int(input()) for _ in range(N)])

sup = 10 ** 9
inf = 0

while sup - inf > 1:
    x = (sup + inf) // 2
    c = sum([math.ceil((h - x * B) / (A - B)) for h in H if h > x * B])
    if c <= x:
        sup = x
    else:
        inf = x

print(sup)

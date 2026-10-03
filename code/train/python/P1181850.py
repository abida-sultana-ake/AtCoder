from math import sqrt


def F(a, b):
    return max(len(str(a)), len(str(b)))

N = int(input())

best = 1<<30
for A in range(1, int(sqrt(N)) + 1):
    B = N // A
    if A * B != N:
        continue
    c = F(A, B)
    if best > c:
        best = c

print(best)
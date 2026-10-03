import math
m, n, N = map(int, input().split())

sumN = 0
amari = 0
fin = 0
while fin == 0:
    sumN += N
    if m > N:
        N += amari
        amari = 0
    if m > N:
        fin = 1
        break
    amari += N % m
    N = math.floor(N / m) * n

print(sumN)

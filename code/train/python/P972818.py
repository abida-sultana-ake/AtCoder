#! /usr/bin/env python3

N, T = map(int, input().split())
A = list(map(int, input().split()))
pu = -1
SPU = set([])
SPD = []
b = 0
c = 0
for i in A[:-1][::-1]:
    if i > A[pu]:
        pu = -c-2
    elif i < A[pu] and A[pu]-i >= b:
        SPU.add(pu)
        b = A[pu]-i
        SPD += [b]
    c += 1

print(min(len(SPU), SPD.count(b)))
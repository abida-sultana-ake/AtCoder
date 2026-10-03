#! /usr/bin/env python3

N, T = map(int, input().split())
A = list(map(int, input().split()))
p = -1
dif = h = hc = lc = c = 0
for i in A[-2::-1]:
    a, b = A[p], A[p]-i
    if i > a:
        p = -c-2
    elif b >= dif:
        if a != h : h, hc = a, hc+1
        if b > dif : dif, lc = b, 0
        lc += 1
    c += 1
print(min(hc, lc))
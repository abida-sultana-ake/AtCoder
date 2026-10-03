# -*- coding: utf-8 -*-

# N, A, B, Xiの入力
n, a, b = map(int, input().split())
x = list(map(int, input().split()))

c = 0
for i in range(1, n):
    ea = (x[i] - x[i-1]) * a
    eb = b

    if ea >= eb:
        c += eb
    else:
        c += ea

print(c)

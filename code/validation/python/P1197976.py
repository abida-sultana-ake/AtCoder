# coding: utf-8

a, k = map(int, raw_input().split())

need = 2000000000000
t = 0
if k == 0:
    print(need - a)
else:
    while a < need:
        a = 1 + a * (k + 1)
        t += 1
    print(t)
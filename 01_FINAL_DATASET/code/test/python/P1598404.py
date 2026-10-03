# -*- coding: utf-8 -*-
import heapq
import math

tmp = input()
A, B, C, D, E, F = [int(a) for a in tmp.split()]

# print valid waters
n1, n2 = [F // (a * 100) for a in [A, B]]
ws = []
for i in range(n1+1):
    for j in range(n2+1):
        if i == 0 and j == 0: continue
        a1, a2 = i, j
        w = (a1 * A + a2 * B) * 100
        if w <= F:
            ws.append(w)
        else:
            break
ws = sorted(ws)
ss = []
for w in ws:
    remain = F - w
    max_sugar = w / 100.0 * E
    max_sugar = min(remain, max_sugar)

    x = 0
    max_tmp = -1
    while x * C < max_sugar:
        y = (max_sugar - (x * C) ) // D
        s = x*C + y*D
        if s > max_tmp:
            max_tmp = s
        x += 1
    ss.append([w, max_tmp])
max_tmp = None
for i, a in enumerate(ss):
    noudo = 1.0 * a[1] / (a[0] + a[1])
    if max_tmp is None or max_tmp[2] < noudo:
        max_tmp = [a[0], a[1], noudo]
print(int(max_tmp[0]+max_tmp[1]), int(max_tmp[1]))

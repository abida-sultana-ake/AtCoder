# -*- coding: utf-8 -*-
N = int(input())
tmp = input()
As = [int(a) for a in tmp.split()]

dic = {}
maxes = [0, 0]
for a in As:
    if a not in dic:
        dic[a] = 0
    dic[a] += 1
    if dic[a] % 2 == 0:
        if maxes[0] < a:
            maxes[0], maxes[1] = a, maxes[0]
        elif maxes[1] < a:
            maxes[1] = a

print(maxes[0] * maxes[1])

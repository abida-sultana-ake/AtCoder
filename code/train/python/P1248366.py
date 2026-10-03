# -*- coding:utf-8 -*-
import itertools
dan = list(map(int,input().split()))
ni = list(map(int,input().split()))
comb_ni = itertools.permutations(ni,3)
comb_dan = itertools.combinations(dan,2)
r = 0
for d in comb_dan:
    for n in comb_ni:
        if d[0]>=n[0] and d[1]>=n[1]:
            a = int(d[0]/n[0])*int(d[1]/n[1])
            dantmp = list(dan)
            dantmp.remove(d[0])
            dantmp.remove(d[1])
            b = int(dantmp[0]/n[2])
            r = max(a*b,r)

print(int(r))

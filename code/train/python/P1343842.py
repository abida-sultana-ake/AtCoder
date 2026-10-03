# -*- coding: utf-8 -*-
n = input()
a = map(int, raw_input().split())
a = sorted(a)

check = [0]*8
ex = 0
for i in range(n):
    if(a[i]<3200):
        check[a[i]/400] = 1
    else:
        ex += 1
l = max(sum(check),1)
h = sum(check)+ex
print(str(l)+' '+str(h))
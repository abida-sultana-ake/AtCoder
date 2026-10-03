# -*- coding:utf-8 -*-
N = int(input())
a = [ tmp for tmp in range(1,10) ]
b = []
for tmp in range(1,7):
    for tmp2 in a:
        b.append(int(str(tmp2)*tmp))
print(b[N-1])
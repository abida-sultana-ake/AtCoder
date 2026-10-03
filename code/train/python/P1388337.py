# -*- coding:utf-8 -*-
import sys
N = int(input())
s = []
for tmp in range(N):
    s.append(int(input()))
s.sort()
total = sum(s)
if total%10 != 0:
    print(total)
else:
    for tmp in s:
        total -= tmp
        if total%10 != 0:
            print(total)
            sys.exit()
        else:
            total += tmp
    print(0)
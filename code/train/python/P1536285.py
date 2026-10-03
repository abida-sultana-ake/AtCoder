# -*- coding:utf-8 -*-
S = list(input())
a = list(map(int, input().split()))
factor = 0
for tmp in a:
    S.insert(tmp+factor,'"')
    factor += 1
print(''.join(S))
# -*- coding:utf-8 -*-
N = int(input())
print(sum([ N-tmp+1 for tmp in range(1,N+1) ]))
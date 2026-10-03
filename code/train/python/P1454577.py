# -*- coding:utf-8 -*-
N, M = map(int, input().split())
a = [ tmp for tmp in range(1, N+1) if tmp != M ]
print(a[0])
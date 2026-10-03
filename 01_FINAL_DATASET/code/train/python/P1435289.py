# -*- coding:utf-8 -*-
import itertools, sys, operator
N, K = map(int, input().split())
t = []
for tmp in range(N):
    a = int(input())
    t.append(a)
for tmp in range(N-2):
    b = tmp+3
    factor = list(itertools.accumulate(t[tmp:b], func=operator.add))
    c = max(factor)
    if c < K:
        print(b)
        sys.exit()
print(-1)
# -*- coding:utf-8 -*-
N, A, B = map(int, input().split())
S = [ int(input()) for _ in range(N) ]
factor = max(S) - min(S)
if factor != 0:
    p = B/(max(S) - min(S))
    q = A-p*(sum(S)/N)
    print(str(p)+' '+str(q))
else:
    print(-1)
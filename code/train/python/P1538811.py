# -*- coding:utf-8 -*-
N, A, B = map(int, input().split())
if N <= 5:
    print(B*N)
else:
    print((N-5)*A+5*B)
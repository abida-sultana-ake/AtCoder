import numpy as np
N,Q,=map(int,input().split(' '))
A=[0 for _ in range(N)]
for _ in range(Q):
    L,R,T,=map(int,input().split(' '))
    A[L-1:R]=[T for _ in range(R-L+1)]
for a in A:
    print(a)
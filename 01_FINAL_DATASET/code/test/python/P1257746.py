# -*- coding:utf-8 -*-
L, H = map(int, input().split())
N = int(input())
A = [int(input()) for tmp in range(N)]
for tmp in range(N):
    if L <= A[tmp] and A[tmp] <= H:
        print(0)
    elif A[tmp] < L:
        print(L-A[tmp])
    else:
        print(-1)
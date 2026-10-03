# -*- coding: utf-8 -*-

N,K = map(int, input().split())

c1=1
c2=3*(N-1)
c3=(K-1)*(N-K)*6

ans = (c1+c2+c3)/(N*N*N)

print(ans)
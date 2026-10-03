from collections import defaultdict as dd
import sys
input = sys.stdin.readline

N,K = map(int,input().split())

d = dd(int)
for i in range(N):
    a,b = map(int,input().split())
    d[a] += b

d = sorted(d.items())
for i,j in d:
    K -= j
    if K <= 0:
        print(i)
        break
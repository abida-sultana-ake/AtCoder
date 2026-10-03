# -*- coding:utf-8 -*-
N = int(input())
s = []
counter = 0
A = 0
T = 0
for tmp in range(N):
    if tmp != 0:
        a = list(input())
        b = [ (i+counter, v) for i,v in enumerate(a) ]
        s = s+b
    else:
        a = list(input())
        s = [ (i, v) for i,v in enumerate(a) ]
    counter += N
s = dict(s)
for tmp in range(N*N):
    if s[tmp] == "R":
        T += 1
    elif s[tmp] == "B":
        A += 1
    else:
        pass
if T > A:
    print("TAKAHASHI")
elif T < A:
    print("AOKI")
else:
    print("DRAW")
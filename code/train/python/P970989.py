#!/usr/bin/env python3
# -*- coding: utf-8 -*-
N,T = map(int,input().split())
As = list(map(int,input().split()))

mns = [0] * N
mxs = [0] * N

mns[0] = As[0]
mxs[N-1] = As[N-1]

for i in range(1, N):
    j = N - i - 1
    mns[i] = min(As[i], mns[i-1])
    mxs[j] = max(As[j], mxs[j+1])

# print(mns)
# print(mxs)

mx_diff = -1
pairs = set()
for i in range(1, N):
    diff = mxs[i] - mns[i]
    if diff > mx_diff:
        mx_diff = diff
        pairs.clear()
    if diff >= mx_diff:
        pairs.add((mns[i], mxs[i]))
print(len(pairs))
    



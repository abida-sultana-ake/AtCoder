# -*- coding:utf-8 -*-
S = list(input())
N = int(input())
for tmp in range(N):
    l,r = map(int, input().split())
    l -= 1
    S2 = list(reversed(S[l:r]))
    for tmp2 in range(len(S2)):
        S[l] = S2[tmp2]
        l += 1
S = ''.join(S)
print(S)
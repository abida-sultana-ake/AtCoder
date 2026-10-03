# -*- coding: utf-8 -*-

# N: # card
# M: days
# A: min. cards
# B: cards to add

N, M, A, B = map(int, input().split())

c = 0
d = []
for i in range(M):
    d.append(int(input()))

for i in range(M):
    if A >= N:
        N = N + B

    N = N - d[i]
    if N < 0:
        print(i + 1)
        c = 1
        break

if c == 0:
    print('complete')
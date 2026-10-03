# -*- coding: utf-8 -*-

import sys
import os
import heapq

N = int(input())

A = list(map(int, input().split()))

B = A[:N]
B_sum = sum(B)
heapq.heapify(B)
dict_b = {}

for i in range(N, 2 * N):
    a = A[i]
    min_val = heapq.heappop(B)
    greater = max(a, min_val)
    heapq.heappush(B, greater)

    if greater != min_val:
        B_sum += (a - min_val)
    dict_b[i] = B_sum


C = A[-N:]
C = [-c for c in C]
C_sum = -1 * sum(C)
heapq.heapify(C)
dict_c = {}

for i in range(2 * N - 1, N - 1, -1):
    a = A[i]
    max_val = -1 * heapq.heappop(C)
    fewer = min(a, max_val)
    heapq.heappush(C, -fewer)

    if fewer != max_val:
        C_sum -= (max_val - a)
    dict_c[i] = C_sum

max_score = max(sum(A[:N]) - dict_c[N], dict_b[2*N-1] - sum(A[-N:]))
for i in range(N, 2 * N - 1):
    score = dict_b[i] - dict_c[i+1]
    if score > max_score:
        max_score = score

print(max_score)
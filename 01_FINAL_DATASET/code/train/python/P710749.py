# -*- coding: utf-8 -*-

N = int(input())

A = [int(input()) for _ in range(N)]
sortedA = sorted(enumerate(A), key = lambda x:x[1])

B = [0 for _ in range(N)]
count = -1
pre = None
for index, num in sortedA:
    if num == pre:
        B[index] = count
    else:
        pre = num
        count += 1
        B[index] = count

for i in range(N):
    print(B[i])       
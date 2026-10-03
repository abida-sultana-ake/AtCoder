#! /usr/bin/env python3

D = 10**9+7
N = int(input())
A = list(map(int, input().split()))
M = N%2>0
b = 1
C = [0] * (N//2+1)
if M:
    for i in A:
        if i%2 < 1:
            C[i//2] += 1 
    b = (N//2) == sum(1 for x in C[1:] if x == 2) and C[0] == 1
    
else:
    for i in A:
        if i%2 > 0:
            C[i//2] += 1 
    b = (N//2) == sum(1 for x in C if x == 2)

print((2**(N//2))%D if b else 0)
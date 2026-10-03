# -*- coding:utf-8 -*-
N = int(input())
S = input()
x = 0
maximum = 0

for factor in range (0, len(S)):
    if S[factor] == 'I':
        x += 1
    elif S[factor] == 'D':
        x -= 1
    
    if maximum < x:
        maximum = x

print(maximum)
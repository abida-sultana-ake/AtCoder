#! /usr/bin/env python3

MOD = 1000000007
N = int(input())
U = input() + ' '
D = input()

s = ''
c = 0
while c < len(U)-1:
    if U[c] == U[c+1]:
        s += 'L'
        c += 2
    else:
        s += 'S'
        c += 1


l = s[0]
a = 3 if l == 'S' else 6
for i in s[1:]:
    if l == i == 'S':
        a = (a * 2) % MOD
    elif l == i == 'L':
        a = (a * 3) % MOD
    elif l == 'S' and i == 'L':
        a = (a * 2) % MOD
    l = i
print(a)

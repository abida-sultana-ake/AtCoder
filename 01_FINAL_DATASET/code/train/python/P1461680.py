# -*- coding: utf-8 -*-
s = input()
N = len(s)

for i in range(1, N):
    if i % 2 == 1:
        continue
    a = s[:((N-i)//2)]
    b = s[((N-i)//2):(N-i)]
    if a == b:
        print(N-i)
        break

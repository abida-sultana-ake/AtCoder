#! /usr/bin/env python3

N = int(input())
t = 100
s = 0
for i in range(N):
    a = int(input())
    s += a
    t = min(t, a) if a % 10 else t
if s % 10 == 0:
    if t % 10 == 0:
        print(0)
    else:
        print(s - t)
else:
    print(s)
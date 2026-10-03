# -*- coding: utf-8 -*-

n = int(raw_input())

power = 1
m = 10**9 + 7

for i in range(n):
    power *= (i+1)
    power %= m

print(power)
#! /usr/bin/env python3
input()
a = list(map(int, input().split()))
s = sorted(a)
cost = []
for y in range(s[0], s[-1]+1):
    cost += [sum((x - y) * (x - y) for x in a)]
print(sorted(cost)[0])
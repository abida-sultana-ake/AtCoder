#!/usr/bin/env python3
x, y = map(int, input().split())
x, y = sorted([ x, y ])
if x == y or x+1 == y:
    print('Brown')
else:
    print('Alice')

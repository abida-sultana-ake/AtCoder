#!/usr/bin/env python3
sx, sy, tx, ty = map(int, input().split())
x = tx - sx
y = ty - sy
s = ''
s += 'U' * y + 'R' * x
s += 'D' * y + 'L' * x
s += 'L' + 'U' * (y+1) + 'R' * (x+1) + 'D'
s += 'R' + 'D' * (y+1) + 'L' * (x+1) + 'U'
print(s)

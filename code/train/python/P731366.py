from math import *

x1, y1, r = map(int, input().split())
x2, y2, x3, y3 = map(int, input().split())

s = {True: 'YES', False: 'NO'}
print(s[not (x2 <= x1-r and x1+r <= x3 and y2 <= y1-r and y1+r <= y3)])
ds = [hypot(x-x1, y-y1) for x,y in [(x2,y2), (x2,y3), (x3,y2), (x3,y3)]]
print(s[max(ds) > r])

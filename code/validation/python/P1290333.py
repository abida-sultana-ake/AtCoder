# -*- coding:utf-8 -*-
import sys
R, C = map(int, input().split())
sy, sx = map(int, input().split())
gy, gx = map(int, input().split())
c, t, ans = ( [], [], 0 )
t.append((sx-1, sy-1, 0))
for tmp in range(R):
    d = list(input())
    e = []
    for tmp2 in range(C):
        f = (d[tmp2], -1)
        e.append(f)
    c.append(e)
c[sy-1][sx-1] = ((c[sy-1][sx-1])[0],0)
while len(t) > 0:
    tmp = t.pop(0)
    x, y, ans = (tmp[0],tmp[1],tmp[2])
    if x == gx-1 and y == gy-1:
        print(ans)
        sys.exit()
    if y-1 >= 0 and (c[y-1][x])[0] == '.' and (c[y-1][x])[1] == -1:
        t.append((x,y-1,ans+1))
        c[y-1][x] = ((c[y-1][x])[0],ans+1)
    if x-1 >= 0 and (c[y][x-1])[0] == '.' and (c[y][x-1])[1] == -1:
        t.append((x-1,y,ans+1))
        c[y][x-1] = ((c[y][x-1])[0],ans+1)
    if y+1 <= R-1 and (c[y+1][x])[0] == '.' and (c[y+1][x])[1] == -1:
        t.append((x,y+1,ans+1))
        c[y+1][x] = ((c[y+1][x])[0],ans+1)
    if x+1 <= C-1 and (c[y][x+1])[0] == '.' and (c[y][x+1])[1] == -1:
        t.append((x+1,y,ans+1))
        c[y][x+1] = ((c[y][x+1])[0],ans+1)
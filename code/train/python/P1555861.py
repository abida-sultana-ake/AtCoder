X,Y,W = input().split()
x,y = int(X)-1, int(Y)-1
src = [input() for i in range(9)]
d = {
    'R': (1,0), 'L':(-1,0), 'U':(0,-1), 'D':(0,1),
    'RU':(1,-1),'RD':(1,1),'LU':(-1,-1),'LD':(-1,1)
}

ans = [src[y][x]]
dx,dy = d[W]
for i in range(3):
    if (x == 0 and dx < 0) or (x == 8 and dx > 0):
        dx *= -1
    if (y == 0 and dy < 0) or (y == 8 and dy > 0):
        dy *= -1
    x += dx
    y += dy
    ans.append(src[y][x])

print(''.join(map(str,ans)))

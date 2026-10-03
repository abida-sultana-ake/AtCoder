from collections import deque

R,C = map(int,input().split())
sx,sy = map(int,input().split()) 
gx,gy = map(int,input().split()) 
sx,sy,gx,gy = sx-1,sy-1,gx-1,gy-1
c = [input() for _ in range(R)]
min = [[R*C for _ in range(C)] for _ in range(R)]
# 次の書き方だと同じオブジェクトIDを持つリストがR個入ったリストになってしまう。このときどれかひとつを変更しようとしてもすべての行が変更されてしまう
# http://qiita.com/utgwkk/items/5ad2527f19150ae33322
# min = [[R*C] * C] * R

x,y = sx,sy
min[y][x]=0
#a = deque()
a = []
a.append((x,y))

while len(a)>0:
#    x,y = a.popleft()
    x,y = a.pop(0)

    for (xo,yo) in [(-1,0),(1,0),(0,-1),(0,1)]:
        if min[y+yo][x+xo] > min[y][x] + 1 and c[y+yo][x+xo] == '.':
            min[y+yo][x+xo] = min[y][x] + 1
            a.append((x+xo,y+yo))

print(min[gx][gy])

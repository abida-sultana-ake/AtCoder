x,y,W=input().split()
c=[list(map(int,input())) for _ in [1]*9]
def func(y,x,dy,dx,l):
    if l==3:return str(c[y][x])
    if not 0<=x+dx<9:dx*=-1
    if not 0<=y+dy<9:dy*=-1
    return str(c[y][x])+func(y+dy,x+dx,dy,dx,l+1)
dx=W.count('R')-W.count('L')
dy=W.count('D')-W.count('U')
print(func(int(y)-1,int(x)-1,dy,dx,0))
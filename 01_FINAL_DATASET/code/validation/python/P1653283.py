ax,ay,bx,by = map(int,input().split())
n = int(input())
ret = 0
px,py = map(int,input().split())
x,y = px,py
for _ in range(n-1):
    qx,qy = map(int,input().split())
    ta = (px - qx) * (ay - py) + (py - qy) * (px - ax)
    tb = (px - qx) * (by - py) + (py - qy) * (px - bx)
    tc = (ax - bx) * (py - ay) + (ay - by) * (ax - px)
    td = (ax - bx) * (qy - ay) + (ay - by) * (ax - qx)
    if ta*tb < 0 and tc*td < 0:ret += 1
    px,py = qx,qy
qx,qy = x,y
ta = (px - qx) * (ay - py) + (py - qy) * (px - ax)
tb = (px - qx) * (by - py) + (py - qy) * (px - bx)
tc = (ax - bx) * (py - ay) + (ay - by) * (ax - px)
td = (ax - bx) * (qy - ay) + (ay - by) * (ax - qx)
if ta*tb < 0 and tc*td < 0:ret += 1
print(ret//2+1)
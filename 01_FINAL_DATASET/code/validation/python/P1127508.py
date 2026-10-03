from collections import namedtuple

xa,ya,xb,yb=map(int,input().split())
n=int(input())
xs,ys=[0]*n,[0]*n
for i in range(n):
    xs[i],ys[i]=map(int,input().split())
xs.append(xs[0])
ys.append(ys[0])

Vec=namedtuple('Vec',('x', 'y'))

def toseg(x1, y1, x2, y2):
    return (Vec(x1,y1), Vec(x2,y2))

def tovec(p1, p2):
    return Vec(p2.x-p1.x, p2.y-p1.y)

def cross(v1, v2):
    return v1.x*v2.y - v1.y*v2.x

def signum(x):
    return 1 if x>=0 else -1

def intersect(seg1, seg2):
    v1 = tovec(seg1[0], seg1[1])
    v2 = tovec(seg1[0], seg2[0])
    v3 = tovec(seg1[0], seg2[1])
    b1 = signum(cross(v1, v2)) != signum(cross(v1, v3))

    v4 = tovec(seg2[0], seg2[1])
    v5 = tovec(seg2[0], seg1[0])
    v6 = tovec(seg2[0], seg1[1])
    b2 = signum(cross(v4, v5)) != signum(cross(v4, v6))

    return b1 and b2

seg1=toseg(xa, ya, xb, yb)
cnt = 0
for i in range(n):
    x1,y1=xs[i],ys[i]
    x2,y2=xs[i+1],ys[i+1]
    seg2=toseg(x1, y1, x2, y2)
    if intersect(seg1, seg2):
        cnt += 1
    x1,y1=x2,y2

print(cnt//2 + 1)

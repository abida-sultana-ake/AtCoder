import math
tx1,ty1,tx2,ty2,T,V = map(int, input().split())
n = int(input())
gs = [tuple(map(int, input().split())) for i in range(n)]

def dist(x1,y1,x2,y2):
    dx = x1-x2
    dy = y1-y2
    return math.sqrt(dx*dx + dy*dy)

def solve():
    for x,y in gs:
        d = dist(tx1,ty1,x,y) + dist(x,y,tx2,ty2)
        if d <= T * V:
            return True
    return False

print('YES' if solve() else 'NO')

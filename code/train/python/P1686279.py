import math,heapq,collections,sys,numpy
sys.setrecursionlimit(10**7)

def LI(): return [int(x) for x in sys.stdin.readline().split()]
def LI_(): return [int(x)-1 for x in sys.stdin.readline().split()]
def LF(): return [float(x) for x in sys.stdin.readline().split()]
def LS(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def S(): return input()

N,K = LI()
p = []
for i in range(N):
    a,b = LI()
    p.append((a,b,i))
sx = sorted(p)
ans = 10**50
for x,y,i in sx:
    for x2,y2,i2 in sx:
        if x2 <= x:
            continue
        points = sx.index((x2,y2,i2)) - sx.index((x,y,i)) + 1
        if points >= K:
            sy2 = sorted(sx[sx.index((x,y,i)):sx.index((x2,y2,i2))+1],key=lambda sx: sx[1])
            for j in range(len(sy2)-K+1):
                if sy2[j][1] <= y and sy2[j+K-1][1] >= y2:          
                    ans = min(ans, (x2 - x) * (sy2[j+K-1][1]-sy2[j][1])) 
print(ans)
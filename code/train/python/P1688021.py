import sys
def LI(): return [int(x) for x in sys.stdin.readline().split()]
 
N,K = LI()
p = []
for i in range(N):
    a,b = LI()
    p.append((a,b))
sx = sorted(p)
ans = 10**50
for x,y in sx:
    for x2,y2 in sx:
        if x2 <= x:
            continue
        points = sx.index((x2,y2)) - sx.index((x,y)) + 1
        if points < K:
            continue
        sy = sorted(sx[sx.index((x,y)):sx.index((x2,y2))+1],key=lambda coor: coor[1])
        for j in range(len(sy)-K, -1, -1):
            if sy[j][1] <= y and y2 <= sy[j+K-1][1]:
                ans = min(ans, (x2 - x) * (sy[j+K-1][1]-sy[j][1])) 
print(ans)
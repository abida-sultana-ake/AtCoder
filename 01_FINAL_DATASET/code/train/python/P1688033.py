N,K = map(int, input().split())
p = []
for i in range(N):
    a,b = map(int, input().split())
    p.append((a,b))
    
sx = sorted(p)
ans = 10**50
for x1,y1 in sx:
    for x2,y2 in sx:
        if x2 <= x1:
            continue
        l = sx.index((x1, y1))
        r = sx.index((x2, y2))
        if r-l+1 < K:
            continue
        sy = sorted(sx[l:r+1],key=lambda coor: coor[1])
        for j in range(len(sy)-K+1):
            if sy[j][1] <= y1 and y2 <= sy[j+K-1][1]:
                ans = min(ans, (x2 - x1) * (sy[j+K-1][1]-sy[j][1])) 
print(ans)
n,ma,mb = map(int, input().split())
p = []
for i in range(n):
    a,b,c = map(int, input().split())
    p.append((a,b,c))

r = [[40001 for j in range(401)] for i in range(401)]
r[0][0] = 0
for i in range(n):
    for j in range(400 - 10*i, -1, -1):
        for k in range(400 - 10*i, -1, -1):
            if 40001 > r[j][k]:
                r[j + p[i][0]][k + p[i][1]] = min(r[j + p[i][0]][k + p[i][1]], r[j][k]+p[i][2])
min_v = 40001
ia = ma
ib = mb
flag  =False
while ia <= 400 and ib<=400:
    if 40001 > r[ia][ib] > 0:
        min_v = min(min_v,  r[ia][ib])
        flag = True
    ia += ma
    ib += mb
        
if not flag:
    print(-1)
else:
    print(min_v)
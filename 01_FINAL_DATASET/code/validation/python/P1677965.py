n = int(input())
a = [list(map(int,input().split())) for i in range(n)]
b = [list(map(int,input().split())) for i in range(n)]
am = [0,0]
for i in a:
    am[0] += i[0]
    am[1] += i[1]
am[0] /= n; am[1] /= n
bm = [0,0]
for i in b:
    bm[0] += i[0]
    bm[1] += i[1]
bm[0] /= n; bm[1] /= n

la = lb = 0.0
for i in a:
    la = max(la, (i[0]-am[0])**2 + (i[1]-am[1])**2)
for i in b:
    lb = max(lb, (i[0]-bm[0])**2 + (i[1]-bm[1])**2)

print((lb/la)**0.5)

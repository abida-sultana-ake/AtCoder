W, H, N = map(int,input().split())
x = []
y = []
a = []
x1 = 0
x2 = W
y1 = 0
y2 = H
for i in range(N):
    temp = list(map(int,input().split()))
    x.append(temp[0])
    y.append(temp[1])
    a.append(temp[2])

for i in range(N):
    if a[i] == 1:
        x1 = max(x1,x[i])
    if a[i] == 2:
        x2 = min(x2,x[i])
    if a[i] == 3:
        y1 = max(y1,y[i])
    if a[i] == 4:
        y2 = min(y2,y[i])
if (x2-x1)<0 or (y2-y1)<0:
    print(0)
else:
    print((x2-x1)*(y2-y1))
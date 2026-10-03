a = list(map(int,input().split(" ")))
b = list()
c = list()
ans = list()

for i in range(a[0]):
    b.append(list(map(int,input().split(" "))))

for i in range(a[1]):
    c.append(list(map(int,input().split(" "))))

for i in range(a[0]):
    d = 0
    e = 9999999999
    for ii in range(a[1]):
        if e > abs(b[i][0] - c[ii][0]) + abs(b[i][1] - c[ii][1]):
            e = abs(b[i][0] - c[ii][0]) + abs(b[i][1] - c[ii][1])
            d = ii
    ans.append(d+1)
    
for i in range(a[0]):
    print(ans[i])
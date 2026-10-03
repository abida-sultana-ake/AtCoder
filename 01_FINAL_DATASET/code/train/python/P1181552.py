INF = 10 ** 10

n,m = map(int,input().split(' '))
a = [0] * n
b = [0] * n
for i in range(n):
    a[i],b[i] = map(int,input().split(' '))
c = [0] * m
d = [0] * m
for i in range(m):
    c[i],d[i] = map(int,input().split(' '))

for i in range(n):
    mn = INF
    mi = -1
    for j in range(m):
        x = abs(a[i]-c[j]) + abs(b[i]-d[j])
        if x < mn:
            mn = x
            mi = j
    print(mi+1)
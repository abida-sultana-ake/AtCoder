from sys import stdin
n,m = map(int,stdin.readline().split())
a = map(int,stdin.readline().split())
b = map(int,stdin.readline().split())
a.sort()
b.sort()
x = []
y = []
for i in xrange(1,n):
    x.append(a[i] - a[i-1])
for i in xrange(1,m):
    y.append(b[i] - b[i-1])   
fir = 0
sec = 0
n = len(x)
m = len(y)
for i in xrange(n):
    fir += (i+1) * (n-i)*x[i]
for i in xrange(m):
    sec += (i+1) * (m-i) * y[i]
mod = 10**9 + 7
print (fir * sec)%mod
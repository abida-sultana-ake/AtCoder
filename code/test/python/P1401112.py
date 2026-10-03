import sys

stdin = sys.stdin

ns = lambda: stdin.readline()
ni = lambda: int(ns())
na = lambda: list(map(int,stdin.readline().split()))

n = ni()
a = na()

l = []
m = []
for i, x in enumerate(a):
    if (i%2==1):
        l.append(x)
    else:
        m.append(x)

if (n%2==0):
    l.reverse()
    l.extend(m)
    ret = l
else:
    m.reverse()
    m.extend(l)
    ret = m

ans = ""
for i, x in enumerate(ret):
    ans += str(x)
    if (i!=n-1): ans += " "
    
print (ans)
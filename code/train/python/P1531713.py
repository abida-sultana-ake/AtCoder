from collections import deque

n = int(input())
uni = list(range(n))
cityx = [None] * n
cityy = [None] * n
for i in range(n):
    x, y = map(int, input().split())
    cityx[i] = (x, i)
    cityy[i] = (y, i)

cityx.sort()
cityy.sort()
dcx, dcy = [], []
for i in range(n - 1):
    dcx.append((cityx[i+1][0] - cityx[i][0], (cityx[i][1], cityx[i+1][1])))
    dcy.append((cityy[i+1][0] - cityy[i][0], (cityy[i][1], cityy[i+1][1])))

dqx = deque(sorted(dcx))
dqy = deque(sorted(dcy))

def root(a):
    if(a == uni[a]):
        return a
    uni[a] = root(uni[a])
    return uni[a]

def connect(a, b):
    a = root(a)
    b = root(b)
    uni[b] = a

ans = 0
while dqx or dqy:
    if(dqx and (not dqy or dqx[0] < dqy[0])):
        d, (i, j) = dqx.popleft()
    else:
        d, (i, j) = dqy.popleft()
    if(root(i) != root(j)):
        ans += d
        connect(i, j)

print(ans)

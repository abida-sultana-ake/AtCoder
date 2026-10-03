N = int(input())
xs, ys = [], []
for _ in range(N):
    x, y = map(int, input().split())
    xs.append(x)
    ys.append(y)

from operator import itemgetter
xis = sorted(list(enumerate(xs)), key=itemgetter(1))
yis = sorted(list(enumerate(ys)), key=itemgetter(1))

xds, yds = [], []
for i in range(N - 1):
    xds.append((xis[i + 1][1] - xis[i][1], (xis[i][0], xis[i + 1][0])))
    yds.append((yis[i + 1][1] - yis[i][1], (yis[i][0], yis[i + 1][0])))

from collections import deque
xdq, ydq = deque(sorted(xds)), deque(sorted(yds))

par = list(range(N))
def find(x):
    if x == par[x]:
        return x
    else:
        par[x] = find(par[x])
        return par[x]

def union(x, y):
    rx, ry = find(x), find(y)
    par[ry] = rx

ans = 0
while xdq or ydq:
    if xdq and (not ydq or xdq[0] < ydq[0]):
        d, (i, j) = xdq.popleft()
    else:
        d, (i, j) = ydq.popleft()
    if find(i) != find(j):
        ans += d
        union(i, j)

print(ans)

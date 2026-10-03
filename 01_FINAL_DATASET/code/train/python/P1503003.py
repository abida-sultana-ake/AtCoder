from operator import itemgetter
from queue import deque

N = int(input())

xin = []
yin = []

for _ in range(N):
    x, y = map(int, input().split())
    xin.append(x)
    yin.append(y)
    
xin = sorted(list(enumerate(xin)), key=itemgetter(1))
yin = sorted(list(enumerate(yin)), key=itemgetter(1))

xd = []
yd = []

for i in range(N-1):
    xd.append((xin[i+1][1] - xin[i][1], (xin[i][0], xin[i+1][0])))
    yd.append((yin[i+1][1] - yin[i][1], (yin[i][0], yin[i+1][0])))
    
xdq = deque(sorted(xd))
ydq = deque(sorted(yd))

par = list(range(N))

def find(x):
    if x == par[x]:
        return x
    else:
        par[x] = find(par[x])
        return par[x]
    
    
def union(x, y):
    px, py = find(x), find(y)
    if px != py:
        par[py] = px
    
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
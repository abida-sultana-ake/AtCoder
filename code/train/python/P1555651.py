import math
N = int(input())
src = [list(map(int,input().split())) for i in range(N)]
ans = 0.0
for i in range(N-1):
    x1,y1 = src[i]
    for j in range(1,N):
        x2,y2 = src[j]
        w = x1-x2
        h = y1-y2
        d = math.sqrt(w*w + h*h)
        ans = max(ans, d)
print(ans)

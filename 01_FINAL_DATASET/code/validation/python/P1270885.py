from collections import deque
H, W = map(int, input().split())
sy, sx = (int(i)-1 for i in input().split())
gy, gx = (int(i)-1 for i in input().split())
m=[]
for y in range(H):
    m.append(list(input()))

dq = deque()
dq.append((sy, sx, 0))
while len(dq)>0:
    y, x, t = dq.popleft()
    if y == gy and x == gx:
        print(t)
        break
    t += 1
    for dy, dx in ((1,0),(0,1),(-1,0),(0,-1)):
        ny, nx = (y+dy, x+dx)
        if m[ny][nx] != "#":
            dq.append((ny, nx, t))
            m[ny][nx] = "#"
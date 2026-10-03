import heapq
H, W, T = map(int, input().split())
a = [list(input()) for i in range(H)]
sx, sy = 0, 0
for y in range(H):
    if "S" in a[y]:
        sx, sy = a[y].index("S"), y

lb, ub = 1, T
for i in range(100):
    mid = (lb+ub)//2
    tt = [[999999999999999]*W for i in range(H)]
    tt[sy][sx] = 0
    q=[(0, sy, sx)]
    flag = False
    while q:
        t, y, x = heapq.heappop(q)
        for dx, dy in ((1,0), (-1,0), (0,1), (0,-1)):
            nx, ny = x+dx, y+dy
            if 0 <= nx < W and 0 <= ny < H:
                dest = a[ny][nx]
                if dest == "G":
                    flag = True
                    break
                cost = 1 if dest=="." else mid
                if t + cost < T and tt[ny][nx] > t+cost:
                    tt[ny][nx] = t+cost
                    heapq.heappush(q, (t+cost, ny, nx))
    if flag:
        lb = mid
    else:
        ub = mid
print(lb)
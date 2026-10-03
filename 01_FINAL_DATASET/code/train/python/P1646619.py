'''
縦 H 行、横 W 列
白マスであれば 1 秒、黒マスであれば x 秒の時間
'''

import heapq
def read_int_list():
  return list(map(int, input().split()))


G=[]
H,W,T = read_int_list()

for i in range(H):
    G.append(list(''.join(input().split())))
    if 'S' in G[i]:
        sy = i
        sx = G[i].index('S')
    if 'G' in G[i]:
        gy = i
        gx = G[i].index('G')



lb, ub = 1, T
for i in range(100):
    mid = (lb+ub)//2
    tt = [[999999999999999]*W for i in range(H)]
    tt[sy][sx] = 0
    q=[(0, sy, sx)]
    flag = False
    while q:
        t, y, x = heapq.heappop(q)
        for dy, dx in ((1,0),(0,1),(-1,0),(0,-1)):
            ny, nx = (y+dy, x+dx)
            if 0 <= ny <= H-1 and 0 <= nx <= W-1:
                d=G[ny][nx]
                if d == 'G':
                    flag = True
                    break
                cnt = 1 if d=='.' else mid
                if t + cnt < T and tt[ny][nx] > t+cnt:
                    tt[ny][nx] = t+cnt
                    heapq.heappush(q, (t+cnt, ny, nx))

    if flag:
            lb = mid
    else:
        ub = mid
print(lb)
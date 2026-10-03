import math

def square(n_cells,N):
    for i in range(max(1,int(n_cells//N)),int(math.sqrt(n_cells))+1):
        yield (i,min(N,n_cells // i))
        yield (min(N,n_cells // i),i)

N = int(input())
D = [list(map(int,input().split())) for _ in range(N)]

Q = int(input())
P = [int(input()) for _ in range(Q)]

DC = [[0]*(N+1) for _ in range(N+1)]
total_max = [[0]*(N+1) for _ in range(N+1)]
for (x,y) in [(i,j) for i in range(1,N+1) for j in range(1,N+1)]:
    DC[x][y] = DC[x-1][y]+DC[x][y-1] -DC[x-1][y-1] + D[x-1][y-1]
    total_max[x][y] = -1

for p in P:
    max_quality = 0

    for (w,h) in square(p,N):
        if total_max[w][h] == -1:
            for (x,y) in [(i,j) for i in range(0,N-w+1) for j in range(0,N-h+1)]:
                    quality = DC[x+w][y+h] - DC[x][y+h] - DC[x+w][y] + DC[x][y]
                    total_max[w][h] = max(total_max[w][h],quality)

        max_quality = max(max_quality,total_max[w][h])

    print(max_quality)

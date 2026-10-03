N,M = map(int,input().split())
fre = [[0 for j in range(N)] for i in range(N)]
for i in range(M):
    a,b = map(int,input().split())
    a,b = a-1, b-1
    fre[a][b] = 1
    fre[b][a] = 1

for i in range(N):
    fresfre = set()
    for j in range(N):
        if fre[i][j] == 0: continue
        for k in range(N):
            if k in (i,j): continue
            if fre[j][k] == 1 and fre[i][k] == 0:
                fresfre.add(k)
    print(len(fresfre))

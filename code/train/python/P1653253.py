n,m = map(int,input().split())
wf = [[1000]*n for _ in range(n)]
for i in range(n):
    wf[i][i] = 0
for i in range(m):
    a,b = map(int,input().split())
    wf[a-1][b-1] = 1
    wf[b-1][a-1] = 1
for k in range(n):
    for i in range(n):
        for j in range(n):
            if wf[i][j] > wf[i][k]+wf[j][k]:
                wf[i][j] = wf[i][k]+wf[j][k]
for i in range(n):
    ret = 0
    for j in range(n):
        if wf[i][j] == 2: ret += 1
    print(ret)
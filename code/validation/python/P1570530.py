N, M = map(int, input().split())
ferry = [list(map(int, input().split())) for i in range(M)]

from_1 = [0 for i in range(N)]
to_N = [0 for i in range(N)]

for f in ferry:
    if f[0]==1:
        from_1[f[1]-1] = 1
    if f[1]==N:
        to_N[f[0]-1] = 1


flag = 0

for k in range(N):
    if from_1[k]==1 and to_N[k]==1:
        print('POSSIBLE')
        flag = 1
        break

if flag==0:
    print('IMPOSSIBLE')

N, M = list(map(int, input().split()))
a = []
l = []
for i in range(N+M):
    a.append(list(map(int, input().split())))
for i in range(0, N):
    l = []
    for j in range(0, M):
        d = abs((a[i][0] - a[N+j][0])) + abs((a[i][1] - a[N+j][1]))
        l.append(d)
    #print(l)
    print(l.index(min(l))+1)
N ,M = map(int, input().split(' '))
cds = [i for i in range(N+1)]
change = [int(input()) for k in range(M)]
p = 0

for x in change:
    i = cds.index(x)
    p = cds[0]
    cds[0] = x
    cds[i] = p

for i in range(N):
    print(cds[i+1])

def func(se, f):
    h = int(se[:2])
    m = int(se[2:])
    if m % 5 != 0:
        if f == 0:
            m -= m % 5
        else:
            m += 5 - m % 5

    return 60*h+m

def funcinv(hm):
    h = hm // 60
    m = hm % 60
    return "{:02d}".format(h) + "{:02d}".format(m)

N = int(input())
SE = [input().split('-') for i in range(N)]
for i in range(N):
    for j in range(2):
        SE[i][j] = func(SE[i][j], j)
SE.sort()

ans = [SE[0]]
for i in range(1, N):
    if SE[i][1] <= ans[-1][1]:
        continue
    if SE[i][0] <= ans[-1][1]:
        ans[-1][1] = SE[i][1]
    else:
        ans.append(SE[i])

for a in ans:
    print(funcinv(a[0])+'-'+funcinv(a[1]))
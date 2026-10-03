N, K = map(int, input().split())
ps = []
for i in range(N):
    a, b = map(int, input().split())
    ps.append([a, b])
ps = sorted(ps)
k = 0
for i in range(N):
    k += ps[i][1]
    if k >= K:
        print(ps[i][0])
        break
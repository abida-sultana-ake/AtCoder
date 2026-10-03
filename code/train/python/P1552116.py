N = int(input())
src = [list(map(int,input().split())) for i in range(N)]
sums = [[0 for j in range(N+1)] for i in range(N+1)]
for i in range(N):
    rowsum = [0]
    for j in range(N):
        rowsum.append(rowsum[-1] + src[i][j])
        sums[i+1][j+1] = sums[i][j+1] + rowsum[j+1]

mem = [[0 for j in range(N)] for i in range(N)]
Q = int(input())
for i in range(Q):
    p = int(input())
    rects = []
    a = max(1, p // N)
    while a*a <= p:
        b = min(N, p // a)
        rects.append((a,b))
        if a != b: rects.append((b,a))
        a += 1
    best = 0
    for h,w in rects:
        if mem[h-1][w-1] > 0:
            best = max(best, mem[h-1][w-1])
            continue
        for sy in range(N-h+1):
            for sx in range(N-w+1):
                pt = sums[sy][sx] + sums[sy+h][sx+w] - sums[sy+h][sx] - sums[sy][sx+w]
                mem[h-1][w-1] = max(mem[h-1][w-1], pt)
        best = max(best, mem[h-1][w-1])
    print(best)

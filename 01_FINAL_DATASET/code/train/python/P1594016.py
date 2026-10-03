N = int(input())
ps = [tuple(map(int,input().split())) for i in range(N)]
ans = 0
for i in range(N-2):
    x1,y1 = ps[i]
    for j in range(i+1,N-1):
        x2,y2 = ps[j]
        for k in range(j+1,N):
            x3,y3 = ps[k]
            # s = |(x2-x1)(y3-y1) - (x3-x1)(y2-y1)| / 2
            sx2 = abs((x2-x1)*(y3-y1) - (x3-x1)*(y2-y1))
            if sx2 != 0 and sx2 % 2 == 0:
                ans += 1
print(ans)

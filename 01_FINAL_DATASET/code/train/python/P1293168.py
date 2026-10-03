N, K = map(int, input().split())
a = [tuple(int(_a) for _a in input().split()) for i in range(N)]

ok, ng = 0, 100
for i in range(100):
    mid = (ok+ng)/2
    _a = sorted([(a[j][0]*a[j][1]/100 - mid*a[j][0]/100) for j in range(N)])
    if sum(_a[-K:]) >= 0:
        ok = mid
    else:
        ng = mid
print((ok+ng)/2)
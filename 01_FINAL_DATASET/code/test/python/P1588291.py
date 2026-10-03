N = int(input())
res = [0 for i in range(6)]
for i in range(N):
    hi,lo = map(float,input().split())
    if hi >= 35:
        res[0] += 1
    elif hi >= 30:
        res[1] += 1
    elif hi >= 25:
        res[2] += 1
    if lo >= 25:
        res[3] += 1
    if lo < 0 and hi >= 0:
        res[4] += 1
    if hi < 0:
        res[5] += 1
print(' '.join(list(map(str,res))))

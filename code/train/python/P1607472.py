N,C = map(int,input().split())
src = [int(input()) for i in range(N)]

ans = N*2
for i in range(1,11):
    for j in range(1,11):
        if i == j: continue
        tmp = 0
        for k in range(N):
            c = i if k%2 == 0 else j
            if src[k] != c:
                tmp += 1
        ans = min(ans, tmp)
print(ans * C)

N = int(input())
p = list(map(int, input().split()))

ans = 0
isZero = False
for i in range(N):
    if p[i] - (i+1) == 0:
        ans += 1
        if isZero:
            ans -= 1
            isZero = False
        else:
            isZero = True
    else:
        isZero = False

print(ans)

N = int(input())
a = list(map(int, input().split()))

sm = sum(a)
if sm % N != 0:
    print(-1)
else:
    b = sm // N
    ans = 0
    sm = 0
    for i in range(N-1):
        sm += a[i]
        if sm != b * (i+1):
            ans += 1
    print(ans)
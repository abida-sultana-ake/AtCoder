n = int(input())
A = list(map(int, input().split()))

ans = 1e16
for s in (1, -1):
    res, acc = 0, 0
    for a in A:
        acc += a
        if acc * s <= 0:
            res += abs(acc-s)
            acc = s
        s *= -1
    ans = min(ans, res)

print(ans)

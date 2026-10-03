a, k = map(int,input().split())
ans = 0
if k == 0:
    ans = 2 * 10 ** 12 - a
else:
    t = a
    while True:
        a += 1 + k * t
        ans += 1
        t = a

        if a >= 2 * 10 ** 12:
            break

print(int(ans))

N = int(input())
s = [int(input()) for i in range(N)]

ans = sum(s)

if ans % 10 == 0:
    s.sort()
    for si in s:
        if si % 10 != 0:
            ans -= si
            break
    else:
        ans = 0

print(ans)

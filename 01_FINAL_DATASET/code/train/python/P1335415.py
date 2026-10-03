n = int(input())
s = [int(input()) for _ in range(n)]
ans = sum(s)
if ans % 10 == 0:
    s.sort(reverse=True)
    while s:
        a = s.pop()
        if a % 10 != 0:
            ans -= a
            break
    else:
        ans = 0
print(ans)

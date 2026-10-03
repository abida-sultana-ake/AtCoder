
a, b, x = list(map(int, input().split()))
ans = 0

if a == 0 or a % x == 0:
    ans += 1

r = b // x
l = a // x

ans += r - l

print(ans)

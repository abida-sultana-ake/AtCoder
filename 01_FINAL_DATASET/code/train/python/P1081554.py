x = int(input())
ans = 0

ans += 2 * (x // (5 + 6))
x %= (5 + 6)

ans += x // 6
x %= 6

if x != 0:
    ans += 1

print(ans)

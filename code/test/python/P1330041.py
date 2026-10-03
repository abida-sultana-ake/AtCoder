n, t = map(int, input().split())
a = [int(input())]
n -= 1
ans = t
for i in range(n):
    a.append(int(input()))
    if a[-1] - a[-2] > t:
        ans += t
    else:
        ans += a[-1] - a[-2]
print(ans)
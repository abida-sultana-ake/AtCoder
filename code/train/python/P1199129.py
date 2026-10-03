from math import pi

n = int(input())
r = [int(input()) for i in range(n)]
r.sort(reverse=True)

ans = 0
for j in range(n):
    area = pi * (r[j] ** 2)
    if j % 2 == 0:
        ans += area
    elif j % 2 == 1:
        ans -= area

print(ans)
input()
a = [0] * (100000 + 1)

for i in map(int, input().split()):
    a[i] += 1
    if a[i] == 3:
        a[i] >>= 1

c = [0, a.count(1), a.count(2)]

ans = 0
ans += (c[2] >> 1) << 1
ans += c[1]

print(ans)



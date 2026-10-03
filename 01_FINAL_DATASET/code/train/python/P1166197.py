
L, R = map(int, input().split())
ls = [int(i) for i in input().split()]
rs = [int(i) for i in input().split()]

lc = [0] * 31
rc = [0] * 31

for size in ls:
    lc[size - 10] += 1

for size in rs:
    rc[size - 10] += 1

ans = 0

for i in range(31):
    ans += min(lc[i], rc[i])

print(ans)
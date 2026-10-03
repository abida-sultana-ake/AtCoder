n, x = map(int, input().split())
a = [int(i) for i in input().split()]
l = len(a)

ans = 0

for i in range(l-1):
    a_0 = a[i]
    a_1 = a[i+1]
    dif = x - a_0
    if a_1 > dif:
        ans += a_1 - dif
        if dif > 0:
            a[i+1] = dif
        else:
            a[i+1] = 0

print(ans)

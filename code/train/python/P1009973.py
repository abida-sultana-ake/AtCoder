n, x = list(map(int, input().split()))
a = list(map(int, input().split()))

count = 0
for i in range(n - 1):
    dif = a[i] + a[i + 1] - x
    if dif > 0:
        if a[i + 1] >= dif:
            a[i + 1] -= dif
            count += dif
        else:
            a[i] -= dif - a[i + 1]
            a[i + 1] = 0
            count += dif
print(count)
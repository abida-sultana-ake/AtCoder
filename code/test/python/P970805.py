
w, h, n = list(map(lambda x: int(x), input().split()))

xr = [0]
xl = [w]
yu = [h]
yd = [0]

for i in range(n):
    x, y, a = list(map(lambda x: int(x), input().split()))

    if a == 1:
        xr.append(x)
    elif a == 2:
        xl.append(x)
    elif a == 3:
        yd.append(y)
    elif a == 4:
        yu.append(y)


x_1 = max(xr) or 0
x_2 = min(xl) or w
y_1 = max(yd) or 0
y_2 = min(yu) or h


ans = (x_2 - x_1) * (y_2 - y_1)

if ans < 0:
    ans = 0

print(ans)

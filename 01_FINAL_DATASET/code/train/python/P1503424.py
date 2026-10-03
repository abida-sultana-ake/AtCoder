n = list(map(int, input().split()))

xa = n[0]
ya = n[1]
xb = n[2]
yb = n[3]
xc = n[4]
yc = n[5]

xb -= xa
xc -= xa
yb -= ya
yc -= ya
ans = abs(xb * yc - yb * xc) / 2
print(ans)

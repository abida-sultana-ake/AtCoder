xa, ya, xb, yb, xc, yc = map(int, input().split())
xb_t = xb - xa
yb_t = yb - ya
xc_t = xc - xa
yc_t = yc - ya
print(abs(xb_t * yc_t - yb_t * xc_t) / 2)

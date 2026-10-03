import math
x1, y1, r = map(int, input().split())
x2, y2, x3, y3 = map(int, input().split())

print("NO" if (x1-r >= x2 and y1-r >= y2) and (x1+r <= x3 and y1+r <= y3) else "YES")
print("NO" if sum([math.sqrt(abs(x1-n)**2+abs(y1-m)**2) <= r for n in (x2, x3) for m in (y2, y3)]) == 4 else "YES")
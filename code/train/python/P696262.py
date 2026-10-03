x1, y1, r = map(int, input().split())
x2, y2, x3, y3 = map(int, input().split())
if x2 <= x1 - r and x1 + r <= x3 and y2 <= y1 - r and y1 + r <= y3:
    print('NO')
else:
    print('YES')
if any((x1 - x) ** 2 + (y1 - y) ** 2 > r ** 2 for x in [x2, x3] for y in [y2, y3]):
    print('YES')
else:
    print('NO')
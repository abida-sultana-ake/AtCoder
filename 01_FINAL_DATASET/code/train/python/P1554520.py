xy = list(map(int, input().split()))

x1 = xy[2] - xy[0]
y1 = xy[3] - xy[1]
x2 = xy[4] - xy[0]
y2 = xy[5] - xy[1]

print(abs(x1 * y2 - x2 * y1) / 2)

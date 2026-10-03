sx, sy, tx, ty = [int(x) for x in input().split()]

# 1周目
dx = tx - sx
dy = ty - sy
route1 = "U" * dy + "R" * dx + "D" * dy + "L" * dx

# 2周目
route2 = "L" + "U" * (dy + 1) + "R" * (dx + 1) + "D" + "R" + "D" * (dy + 1) + "L" * (dx + 1) + "U"

print(route1 + route2)

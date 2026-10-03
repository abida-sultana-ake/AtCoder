
sx, sy, tx, ty = map(int, input().split())
ans = ""

dir_x = ["", "R", "L"]
dir_y = ["", "U", "D"]

dx = 1 if (tx - sx > 0) else -1
dy = 1 if (ty - sy > 0) else -1

ans += dir_x[dx] * abs(tx - sx)
ans += dir_y[dy] * abs(ty - sy)

ans += dir_x[-dx] * abs(tx - sx)
ans += dir_y[-dy] * abs(ty - sy)

ans += dir_y[-dy]
ans += dir_x[dx] * (abs(tx - sx) + 1)
ans += dir_y[dy] * (abs(ty - sy) + 1)
ans += dir_x[-dx]

ans += dir_y[dy]
ans += dir_x[-dx] * (abs(tx - sx) + 1)
ans += dir_y[-dx] * (abs(ty - sy) + 1)
ans += dir_x[dx]

print(ans)
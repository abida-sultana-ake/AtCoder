sx, sy, tx, ty = tuple(int(x) for x in input().split())

ans = ''
ans += 'U' * abs(ty - sy)
ans += 'R' * abs(tx - sx)
ans += 'D' * abs(ty - sy)
ans += 'L' * abs(tx - sx)
ans += 'L'
ans += 'U' * (abs(ty - sy) + 1)
ans += 'R' * (abs(tx - sx) + 1)
ans += 'D'
ans += 'R'
ans += 'D' * (abs(ty - sy) + 1)
ans += 'L' * (abs(tx - sx) + 1)
ans += 'U'

print(ans)
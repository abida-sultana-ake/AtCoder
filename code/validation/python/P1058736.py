sx,sy,tx,ty = map(int,input().split())
dy , dx = ty-sy,tx-sx
ans = "U" * dy + "R" * dx
ans += "D" * dy + "L" * dx 
ans += "L" + "U" * (dy+1) + "R" * (dx+1) + "D"
ans += "R" + "D" * (dy+1) + "L" * (dx+1) + "U"
print(ans)
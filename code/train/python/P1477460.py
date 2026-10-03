import math

x1, y1, r = map(int, input().split())
x2, y2, x3, y3 = map(int, input().split())

if x1 - r < x2 or x1 + r > x3 or y1 - r < y2 or y1 + r > y3:
  print('YES')
else:
  print('NO')
  
if math.hypot(x1 - x2, y1 - y2) > r or math.hypot(x1 - x3, y1 - y3) > r or math.hypot(x1 - x2, y1 - y3) > r or math.hypot(x1 - x3, y1 - y2) > r:
  print('YES')
else:
  print('NO')

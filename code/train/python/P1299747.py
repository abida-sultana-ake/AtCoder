h,w = sorted(list(map(int,input().split())))
if h % 3 == 0 or w % 3 == 0:
  ret = 0
else:
  c1 = ((w//3+1)*h)-((w-1-w//3)*(h//2))
  c2 = ((w-w//3)*(h-h//2))-(w//3*h)
  c3 = h
  c4 = ((h//3+1)*w)-((h-1-h//3)*(w//2))
  c5 = ((h-h//3)*(w-w//2))-(h//3*w)
  ret = min(c1,c2,c3,c4,c5)
print(ret)

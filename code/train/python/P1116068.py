u, v = map(int, input().split())
if 2*u > v:
  print(v//2)  
else:
  print((2*u+v)//4)

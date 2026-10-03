a=sorted([int(input()) for _ in [0]*int(input())])
s=0
f=0 #false

while a:
  if f: s -= a.pop()**2
  else :s += a.pop()**2
  f= not f
import math
print(s*math.pi)
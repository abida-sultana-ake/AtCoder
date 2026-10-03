N = int(input())
s = list(map(lambda x: x == 'o', input()))

# try all 4 cases

from itertools import product
for a,b in product((True,False), repeat=2):
  x,y = a,b
  for p in s:
    a,b = b, a^b^p

  if x == a and y == b:
    temp = [None]*N
    for i,p in enumerate(s):
      temp[i] = b
      a,b = b, a^b^p
    print(''.join('S' if t else 'W' for t in temp))
    exit()

print(-1)

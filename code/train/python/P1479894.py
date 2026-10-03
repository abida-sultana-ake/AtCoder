n = int(input())
r = b = 0
for i in range(n):
  str = input()
  for e in list(str):
    if e == 'R': r+=1
    elif e == 'B': b+=1

if r > b:
  print("TAKAHASHI")
elif r < b:
  print("AOKI")
else:
  print("DRAW")

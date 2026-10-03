lst = []
arr = [['' for i in range(4)] for j in range(4)]
for _ in range(4):
  lst.append(input().replace(' ',''))

for x in range(4):
  for y in range(4):
    arr[3 - x][3 - y] = lst[x][y]

for x in arr:
  print(' '.join(x))
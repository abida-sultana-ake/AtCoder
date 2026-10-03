N = int(input())
A = list(map(int, input().split()))

odd = 0
n2 = 0
n4 = 0

for a in A:
  r = a % 4
  if r == 0:
    n4 += 1
  elif r == 2:
    n2 = 1
  else:
    odd += 1

if n4 + 1 >= odd + n2:
  print('Yes')
else:
  print('No')
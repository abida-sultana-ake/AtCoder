import math

n = int(input())
coins = [int(input()) for _ in range(n)]

e = 0
for i in range(n):
  count = 0
  for j in range(n):
    if coins[i] % coins[j] == 0:
      count += 1
  
  e += math.ceil(count / 2) / count

print(e)
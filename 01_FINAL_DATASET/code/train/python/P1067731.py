from collections import defaultdict
from functools import reduce

P = 10**9 + 7

N = int(input())

rem = list(range(2, N+1))
dic = defaultdict(int)

while len(rem) > 0:
  n = rem[-1]
  for d in range(2, int(n**0.5) + 1):
    if n % d == 0:
      dic[d] += 1
      rem[-1] //= d
      break
  else:
    dic[n] += 1
    rem.pop()

print(reduce(lambda x, y: x*(y+1)%P, dic.values(), 1))

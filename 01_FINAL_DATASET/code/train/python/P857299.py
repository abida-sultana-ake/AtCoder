
from collections import defaultdict
N, A = map(int, input().split())

X = map(lambda s: int(s) - A, input().split())

counter = defaultdict(int)
counter[0] = 1

for x in X:
  for d,c in list(counter.items()):
    counter[d+x] += c

print(counter[0]-1)
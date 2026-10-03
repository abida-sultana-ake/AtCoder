import collections

n, m = map(int, input().split())

r = collections.defaultdict(list)

for _ in range(m):
  a, b = map(int, input().split())
  r[a].append(b)
  r[b].append(a)

for i in range(1, n + 1):
  s = set()
  for f in r[i]:
    for ff in r[f]:
      if ff not in r[i] and ff != i:
        s.add(ff)
  print(len(s))
  

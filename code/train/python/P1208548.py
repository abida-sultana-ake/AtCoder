n = int(input())
d = {}
for i in range(n):
  dd = {}
  for ch in input():
    dd[ch] = dd.get(ch, 0) + 1
  if i:
    for v in d:
      d[v] = min(d[v], dd.get(v,0))
  else:
    d = dd
for v in sorted(d.keys()):
  print(v*d[v], end = "")
print()  
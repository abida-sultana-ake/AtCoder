N = int(input())
S = str(input())

v = 0
record = 0
for k in S:
  if (k == 'I'):
    record += 1
  else:
    record -= 1
  v = max(v, record)

print(v)

a, d = map(int, input().split())

if (a + 1) * d >= a * (d + 1):
  a += 1
else:
  d += 1

print(a * d)

m = int(input())
a = 1
for c in range(7):
  if (2 ** c) > m:
    break
  a = (2 ** c)

print(a)

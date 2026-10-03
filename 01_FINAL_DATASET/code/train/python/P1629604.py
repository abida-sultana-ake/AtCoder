n, s, t = map(int, input().split())
w = int(input())

res = 0
for i in range(n):
  if i >= 1:
    a = int(input())
    w += a
  if w >= s and w<=t:
    res += 1
print(res)

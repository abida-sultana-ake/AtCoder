N=int(input())

def f(x):
  r = 0
  while x > 0:
    r += x % 10
    x //= 10
  return r

ans = []
for i in range(1000):
  x = N - i
  if x > 0 and x + f(x) == N:
    ans.append(x)
ans.sort()
print(len(ans))
for x in ans:
  print(x)
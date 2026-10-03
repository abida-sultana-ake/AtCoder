N=int(input())
C = [ int(input()) for _ in range(N) ]

def f(M):
  s = 0.0
  for e in range(0, M, 2):
    s += 1.0
  return s / M

ans = 0.0
for c in C:
  m = 0
  for d in C:
    if c % d == 0:
      m += 1
  ans += f(m)
  
print(ans)
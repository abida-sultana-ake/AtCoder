def pgcd(a,b):
  while b:
    a,b = b,a%b
  return a

ret = 1
N = int(input())
for _ in range(N):
  T = int(input())
  p = pgcd(ret,T)
  ret *= (T//p)

print(ret)
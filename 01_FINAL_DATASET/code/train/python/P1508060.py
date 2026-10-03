def gcd(a, b):
  if b == 0:
    return a
  return gcd(b, a % b)   

n=int(input())
p=1
for i in range(n):
  m=int(input())
  p=p*m//gcd(p,m)
print(int(p))
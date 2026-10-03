n, m = map(int, input().split())

if(m >= 2*n):
  m -= 2*n
  q = m // 4
  print(n + q)
else:
  print(m//2)
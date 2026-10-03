N,M=map(int,input().split())
for a in range(0, N+1):
  n = N - a
  m = M - 2*a
  b = 4*n-m
  c = m - 3*n
  if n >= 0 and m >= 0 and b >= 0 and c >= 0:
    print(a,b,c)
    break
else:
  print(-1,-1,-1)

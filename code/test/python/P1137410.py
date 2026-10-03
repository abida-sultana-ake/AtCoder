N,K=map(int,input().split())
A = [ int(input()) for _ in range(N) ]
if 0 in A:
  print(N)
  import sys
  sys.exit()
a = 0
b = 0
k = 1
ans = 0
while a < N:
  if k <= K:
    ans = max(ans, b - a)
  if (k > K or b == N) and a < b:
    k = k // A[a]
    a += 1
  else:
    k = k * A[b]
    b += 1
print(ans)
N,K=map(int,input().split())
A=[ list(map(int,input().split())) for _ in range(N) ]

ans = False
def f(n, s):
  global ans
  if n == N:
    ans = ans or s == 0
    return
  for x in A[n]:
    f(n+1, s^x)

f(0,0)
if ans :
  print("Found")
else:
  print("Nothing")
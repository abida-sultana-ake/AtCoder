N,M=map(int,input().split())
g = [ [False] * N for _ in range(N) ]
for _ in range(M):
  a,b=map(int,input().split())
  a -= 1
  b -= 1
  g[a][b] = True
  g[b][a] = True
ans = 0
dp = [False] * (1 << N)
dp[0] = True
for st in range(1, 1 << N):
  ok = True
  fst = -1
  one = 0
  for i in range(N):
    if (st >> i & 1) == 1:
      one += 1
      if fst == -1:
        fst = i
      elif g[i][fst] == False:
        ok = False
  ok = ok and dp[st ^ (1 << fst)]
  dp[st] = ok
  if ok:
    ans = max(ans, one)
print(ans)
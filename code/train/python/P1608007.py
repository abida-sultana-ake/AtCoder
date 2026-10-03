import sys
N,W = map(int, raw_input().split())
src = []
wmax = vmax = 0
for i in range(N):
  w,v = map(int, raw_input().split())
  src.append((w,v))
  wmax += w
  vmax += v
w1 = src[0][0]

if w1 > W:
  print(0)
  sys.exit()
if wmax <= W:
  print(vmax)
  sys.exit()

wend = 3*N+1
dp = [[0 for w in range(wend)] for n in range(N+1)]
for i in range(N):
  wi,vi = src[i]
  wi -= w1 # 0 <= wi <= 3
  maxn = min(N,i+1)
  for n in reversed(range(1,maxn+1)):
    for w in range(wi,wend):
      dp[n][w] = max(dp[n][w], dp[n-1][w-wi] + vi)

ans = 0
for n in range(1,N+1):
  remain = W - w1*n
  if remain < 0: break
  w = min(remain, wend-1)
  ans = max(ans, dp[n][w])

print(ans)
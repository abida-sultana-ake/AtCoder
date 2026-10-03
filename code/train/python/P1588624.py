import itertools

N,M,R=map(int,input().split())
r=list(map(int,input().split()))
for i in range(R): r[i] -= 1

g = [ [1001001001] * N for _ in range(N) ]
for i in range(N):
  g[i][i] = 0

for _ in range(M):
  A,B,C=map(int,input().split())
  A-=1
  B-=1
  g[A][B] = C
  g[B][A] = C

def md(beg):
  d = [1001001001] * N
  done = [False] * N
  d[beg] = 0
  while True:
    cur = 1001001001
    pos = -1
    for i in range(N):
      if not done[i] and cur > d[i]:
        cur = d[i]
        pos = i
    if pos == -1:
      break
    done[pos] = True
    for i in range(N):
      d[i] = min(d[i], d[pos] + g[pos][i])
  return d

for i in range(R):
  g[r[i]] = md(r[i])

ans = 1001001001
for p in itertools.permutations(r):
  cur = 0
  for i in range(1, R):
    cur += g[p[i-1]][p[i]]
  ans = min(ans, cur)
print(ans)

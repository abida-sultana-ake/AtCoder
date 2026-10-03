import heapq

FI,LA = raw_input().split()
N = input()
wordset = set([FI,LA])
for i in range(N):
  wordset.add(raw_input())
words = list(wordset)
WN = len(words)
start = words.index(FI)
end = words.index(LA)

def can_move(s1,s2):
  diff = 0
  for c1,c2 in zip(s1,s2):
    if c1 != c2:
      diff += 1
      if diff > 1: return False
  return True

es = [[0 for i in range(WN)] for j in range(WN)]
for i in range(WN-1):
  for j in range(i+1,WN):
    if can_move(words[i], words[j]):
      es[i][j] = es[j][i] = 1

INF = 999999
def solve():
  if start == end: return[start,end]
  mindeps = [INF for i in range(WN)]
  mindeps[start] = 0
  prevs = [-1 for i in range(WN)]
  q = [(0,start)]
  heapq.heapify(q)
  while q:
    depth,now = heapq.heappop(q)
    if now == end:
      route = []
      while now >= 0:
        route.append(now)
        now = prevs[now]
      return route[::-1]
    for i in range(WN):
      if depth >= mindeps[i] : continue
      if es[now][i]:
        heapq.heappush(q,(depth+1,i))
        mindeps[i] = depth+1
        prevs[i] = now
  return -1

result = solve()
if result == -1:
  print(-1)
else:
  print(len(result)-2)
  for r in result:
    print(words[r])
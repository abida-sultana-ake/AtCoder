N, M = map(int, input().strip().split(" "))

head = [-1 for _ in range(N + 1)]
edge= [-1 for _ in range(M + 1)]
next = [-1 for _ in range(M + 1)]

tot = 0

def add_edge(a, b):
  global tot
  edge[tot] = b
  next[tot] = head[a]
  head[a] = tot
  tot += 1

for _ in range(M):
  a, b = map(int, input().strip().split(" "))
  add_edge(a, b)

def find(start, step):
  if step == 0:
    if start == N:
      return True
    else:
      return False
  p = head[start]
  while p != -1:
    if find(edge[p], step - 1) == True:
      return True
    p = next[p]
  return False

if find(1, 2) == True:
  print("POSSIBLE")
else:
  print("IMPOSSIBLE")
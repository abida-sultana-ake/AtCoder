import random
N,M,K = map(int,raw_input().split())
rel = [[0 for j in range(N)] for i in range(N)]
for i in range(M):
  a,b = map(int,raw_input().split())
  rel[a][b] = 1
  rel[b][a] = 1

def rand2():
  r = random.randint(0,N*(N-1)-1)
  r1,r2 = r%N, r//N
  if r2 >= r1: r2 += 1
  return(r1,r2)

def attempt():
  order = [i for i in range(N)]
  for i in range(K):
    r1,r2 = rand2()
    order[r1],order[r2] = order[r2],order[r1]
  if rel[order[0]][order[N-1]]:
    return 0
  for i in range(0,N-1):
    if rel[order[i]][order[i+1]]:
      return 0
  return 1

T = 240000
ok = 0
for i in range(T):
  ok += attempt()
print(ok*1.0 / T)
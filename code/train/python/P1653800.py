N, M = [int(n) for n in input().split()]
students = []
for i in range(N):
  a, b = [int(n) for n in input().split()]
  students.append((a,b))

checkpoints = []
for i in range(M):
  c, d = [int(n) for n in input().split()]
  checkpoints.append((c,d))

st_cp=[]

for a, b in students:
  min_d=10000000000
  cp = 0
  for m, (c, d) in enumerate(checkpoints):
    dist = abs(a-c) + abs(b-d)
    if dist < min_d:
      min_d = dist
      cp = m+1
  st_cp.append(cp)

for i in range(N):
  print(st_cp[i])
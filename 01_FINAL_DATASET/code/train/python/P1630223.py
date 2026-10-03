N, M = [int(n) for n in input().split()]
check = [0] * N
for m in range(M):
  a, b = [int(n) - 1 for n in input().split()]
  if a == 0:
    check[b] += 1
  if b == N-1:
    check[a] += 1
flag = False
for n in range(N):
  if check[n] == 2:
    flag = True

if flag == True:
  print("POSSIBLE")
else:
  print("IMPOSSIBLE")
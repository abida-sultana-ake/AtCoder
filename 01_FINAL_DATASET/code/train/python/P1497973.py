N, K = map(int, input().split())
D = list(map(int, input().split()))
L = [i for i in range(10) if i not in D]
A = []
for i in L:
  A.append(i)
for i in L:
  for j in L:
    A.append(10*i+j)
for  i in L:
  for j in L:
    for k in L:
      A.append(100*i+10*j+k)
for i in L:
  for j in L:
    for k in L:
      for l in L:
        A.append(1000*i+100*j+10*k+l)

for i in L:
  for j in L:
    for k in L:
      for l in L:
        for m in L:
          A.append(\
10000*i+1000*j+100*k+10*l+m)

for i in A:
  if i >= N:
    print(i)
    break
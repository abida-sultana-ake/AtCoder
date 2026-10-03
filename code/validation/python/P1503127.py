N = int(input())
a = list(map(int,input().split()))

A = [[j,i+1] for i,j in enumerate(a)]
A.sort(reverse=True)

for k in range(N):
  print(A[k][1])

import sys
N,M=map(int,input().split())
A=[]
B=[]
A+=[str(input()) for i in range(N)]
B+=[str(input()) for i in range(M)]
for i in range(N-M+1):
  for j in range(N-M+1):
    ans=1
    for k in range(M):
      for l in range(M):
        if B[k][l]!=A[i+k][j+l]:
          ans=0
    if ans:
      print("Yes")
      sys.exit()
print("No")
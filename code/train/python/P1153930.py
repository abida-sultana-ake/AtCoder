n,k=map(int,input().split())
x=list(int(input())for i in range(n))
for i in range(n-2):
 if x[i]+x[i+1]+x[i+2]<k:
  print(i + 3)
  break
else:print(-1)
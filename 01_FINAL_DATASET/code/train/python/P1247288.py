N = int(input())  
d = [int(input()) for i in range(N)]  
x=sum(d)
print(x)
a=[d[0],0]
for i in range(1,N):
 if a[0]<d[i]:
   a[0]=d[i]
   a[1]=i
if a[0]>sum(d[:a[1]])+sum(d[a[1]+1:]):
  print(a[0]-sum(d[:a[1]])-sum(d[a[1]+1:]))
  
else:
  print(0)
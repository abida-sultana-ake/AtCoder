N=int(input())
a=list(map(int,input().split()))
b=[]
if N%2==0:
  for i in range(int(N/2)):
    b+=[a[N-1-2*i]]
  for i in range(int(N/2)):
    b+=[a[2*i]]
else:
  for i in range(int((N+1)/2)):
    b+=[a[N-1-2*i]]
  for i in range(int((N-1)/2)):
    b+=[a[2*i+1]]
print(' '.join(map(str, b)))
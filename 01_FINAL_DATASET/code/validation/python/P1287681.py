N=int(input())
A=list(map(int,input().split()))
A.sort()
B=[]#偶数だけ
C=[]#奇数だけ

if N%2==0:
  for i in range(0,int(N/2)):
    B+=[2*i,2*i]
    C+=[2*i+1,2*i+1]
  if A==B or A==C:
    n=int(N/2)
    ans=2**n
    print(ans%(10**9+7))
  else:
    print(0)
else:
  B+=[0]
  C+=[1]
  for i in range(0,int(N/2)):
    B+=[2*i+2,2*i+2]
    C+=[2*i+3,2*i+3]
  if A==B or A==C:
    n=int((N-1)/2)
    ans=2**n
#    ans=2**((N-1)/2)
    print(ans%(10**9+7))
  else: 
    print(0)
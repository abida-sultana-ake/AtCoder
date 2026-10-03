N,X=map(int,input().split())
A=list(map(int,input().split()))
A.reverse()
bi=str(format(X,"b"))
bi="0"*(N-len(bi))+bi

ans=0
for i in range(N):
  if bi[i]=="1":
    ans+=A[i]
print(ans)
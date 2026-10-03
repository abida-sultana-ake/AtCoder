H,W=map(int,input().split())
N=int(input())
a=list(map(int,input().split()))

b=[]
for i in range(N):
  b+=[i+1]*a[i]
ans=[0]*H
for i in range(H):
  if i%2==0:
    print(" ".join(map(str,b[i*W:(i+1)*W])))
  else:
    print(" ".join(map(str,b[(i+1)*W-1:(i)*W-1:-1])))
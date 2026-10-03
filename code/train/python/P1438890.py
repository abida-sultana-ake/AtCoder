
N,K=map(int,input().split())
l=list(map(int,input().split()))
n=0.0
for i in sorted(l)[-K:]:
   n=(n+i)/2
print(n)

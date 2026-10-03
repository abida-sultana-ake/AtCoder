N,M=map(int,input().split())
bin=[0]*(M+1)
s=0
for _ in range(N):
  a,b,c=map(int,input().split())
  bin[a-1]+=c
  bin[b]-=c
  s+=c
for i in range(M):
  bin[i+1]+=bin[i]
print(s-min(bin[:-1]))
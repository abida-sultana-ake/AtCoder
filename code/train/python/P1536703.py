N,S,T=map(int,input().split())
days=0
weight=0
for i in range(N):
  weight+=int(input())
  if S<=weight and weight<=T: days+=1
print(days)
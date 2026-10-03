A,B,C,K=map(int,input().split())
S,T=map(int,input().split())
if S+T>=K: 
  print(S*A+B*T-C*(S+T))
else: print(S*A+B*T)
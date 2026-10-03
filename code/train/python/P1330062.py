import math
N,A,B=map(int,input().split())
S=[]
for i in range(N):
  S+=[int(input())] 
S.sort(reverse=1)
count=0

def Check(T):
  count=0
  for i in range(N):
    a=math.ceil((S[i]-B*T)/(A-B))
    if a>0:
      count+=a
    else:
      break
  if count<=T:
    return 1
  else:
    return 0

L=1
while True:
  if S[0]/B >=2**L:
    L+=1
  else:
    break

T=2**L#checkしたいナンバー。
for l in range(L,0,-1):
  if Check(T)==1:
    T-=2**(l-1)
  elif Check(T)==0:
    T+=2**(l-1)
if Check(T)==0:
  print(T+1)
else:
  print(T)
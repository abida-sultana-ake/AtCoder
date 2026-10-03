N=int(input())
sp=[]
total=0
for _ in range(N):
  s,p=input().split()
  sp+=[[s,int(p)]]
  total+=int(p)
sp=sorted(sp,key=lambda x:x[1],reverse=1)
if sp[0][1]>total/2:
  print(sp[0][0])
else: print("atcoder")
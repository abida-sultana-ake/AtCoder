def BFS(i,A,N):
  dist=[0]*N
  d=[-1]*N
  d[i]=0#未訪問ならd=-1,訪問済みならiからの距離
  que=[i]
  dist=1
  while que:
    for j in range(len(que)):
      label=que.pop(0)
      for i in range(len(A[label])):
        if d[A[label][i]]==-1:
          d[A[label][i]]=dist
          que+=[A[label][i]]
    dist+=1
  return(d)

N=int(input())
ab=[]
for i in range(N-1):
  ab.append(list(map(int, input().split())))
A=[ [] for i in range(N) ]
for i in range(N-1):
  A[ab[i][0]-1]+=[ab[i][1]-1]
  A[ab[i][1]-1]+=[ab[i][0]-1]
 
 
dist1=BFS(0,A,N)
dist2=BFS(N-1,A,N)
Fe=0
Su=0
for i in range(N):
  if dist1[i]<=dist2[i]:
    Fe+=1
  else:
    Su+=1
if Fe>Su:
  print("Fennec")
else:
  print("Snuke")
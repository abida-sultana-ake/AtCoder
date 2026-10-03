from collections import*
n=input();G=[[]for d in[deque([1,n])]*-~n]
for C in[[0,1]+[0]*(n-2)+[2]]*~-n:a,b=map(int,raw_input().split());G[a]+=b,;G[b]+=a,
while d:
 v=d.popleft()
 for t in G[v]:
  if C[t]<1:C[t]=C[v];d+=t,
print["Snuke","Fennec"][n<2*C.count(1)]
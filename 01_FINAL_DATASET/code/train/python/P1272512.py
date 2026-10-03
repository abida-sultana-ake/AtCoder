N,M=list(map(int, input().split()))
a=[]
c=[]
for n in range (0,N):
  a.append(list(map(int, input().split())))
for m in range(0,M):
  c.append(list(map(int, input().split())))

ans=[]
for n in range (0,N):
  place=1
  dist=abs(a[n][0]-c[0][0])+abs(a[n][1]-c[0][1])
  for m in range(1,M):
    if abs(a[n][0]-c[m][0])+abs(a[n][1]-c[m][1])<dist:
      dist=abs(a[n][0]-c[m][0])+abs(a[n][1]-c[m][1])
      place=m+1
  ans.append(place)

for n in range (0,N):
  print(ans[n])
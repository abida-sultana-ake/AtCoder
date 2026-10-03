a=[int(i) for i in input().split()]
b=[]
for i in range(a[2]):
  b.append([int(j) for j in input().split()])
import collections
import time
c=[]
d=[0 for i in range(10)]
for i in range(len(b)):
  for jj in [-2,-1,0]:
    for kk in [-2,-1,0]:
      if 0<b[i][0]+jj<a[0]-1 and 0<b[i][1]+kk<a[1]-1:
       c.append((b[i][0]+jj,b[i][1]+kk))
count_dict = collections.Counter(c)
n=count_dict.values()
for i in n:
  d[i]+=1
d[0]=(a[0]-2)*(a[1]-2)-len(n)
for j in range(10):
 print(d[j])

import itertools
n,m=map(int,input().split());d={i:{i}for i in range(n)};a=1
for _ in range(m):x,y=[int(t)-1 for t in input().split()];d[x].add(y);d[y].add(x)
for j in itertools.product([0,1],repeat=n):
 o=[d[i]for i,k in enumerate(j)if k];l=len(o)
 if l==len(set(range(n)).intersection(*(o or[[]]))):a=max(a,l)
print(a)
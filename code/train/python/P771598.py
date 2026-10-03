N=int(input().strip())
a=[int(x) for x in input().strip().split()]
c=[100000 for x in a]
c[0]=0
c[1]=abs(a[1]-a[0])

for i in range(2,N):
    c[i]=min(c[i-1]+abs(a[i]-a[i-1]),c[i-2]+abs(a[i]-a[i-2]))
print(c[N-1])

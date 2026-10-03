
x=[]
xsum=0
ysum=0
y=[]
n,m = map(int,input().split())
x=input().split()
y=input().split()

for i in range(n):
    xsum += ((-1)*(n-i-1)+i)*(int(x[i]))
for i in range(m):
    ysum += ((-1)*(m-i-1)+i)*(int(y[i]))

print ((xsum * ysum)%(10**9+7))

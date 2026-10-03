n=int(input())
a=[int(i) for i in input().split()]
cost=[0]*n
cost[1]=abs(a[1]-a[0])

for i in range(2,n):
    cost[i]=min(cost[i-2]+abs(a[i]-a[i-2]),cost[i-1]+abs(a[i]-a[i-1]))
print(cost[n-1])

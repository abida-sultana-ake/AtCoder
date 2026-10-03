n,m=map(int,input().split())
arr=[0]*n
for _ in range(m):
    a,b=map(int,input().split())
    arr[a-1]+=1
    arr[b-1]+=1
for road in arr:
    print(road)

n,t = map(int,input().split())
arr=list(map(int,input().split()))
total=0
for i in range(1,n):
    if arr[i]-arr[i-1]<t:
        total+=arr[i]-arr[i-1]
    else:
        total+=t
total+=t
print(total)

n=int(input())
arr=list(map(int,input().split()))
brr=[]
if n%2==0:
    for i in range(n-1,0,-2):
        brr.append(arr[i])
    for i in range(0,n-1,2):
        brr.append(arr[i])
else:
    for i in range(n-1,-1,-2):
        brr.append(arr[i])
    for i in range(1,n,2):
        brr.append(arr[i])
print(' '.join(list(map(str,brr))))

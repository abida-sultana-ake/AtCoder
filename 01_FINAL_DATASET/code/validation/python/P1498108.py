h,w=map(int,input().split())
n=int(input())
arr=list(map(int,input().split()))
def nextPoint(i,j):
    if i%2==0 and j<w-1:
        return (i,j+1)
    elif i%2==1 and j>0:
        return (i,j-1)
    elif j==0 or j==w-1:
        return(i+1,j)

ans = [[0 for col in range(w)] for row in range(h)]
cur=(0,0)
for i in range(n):
    for _ in range(arr[i]):
        ans[cur[0]][cur[1]]=i+1
        cur=nextPoint(cur[0],cur[1])
for row in ans:
    print(' '.join(list(map(str,row))))

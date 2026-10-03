import sys
N=int(input())
a=list(map(int,input().split()))
b=[0 for _ in range(N)]
if(N%2==0):
    l=int(N/2)-1
else:
    l=int(N/2)
r=l+1
for i in range(N):
    if(i%2==(N-1)%2):
        b[l]=a[i]
        l-=1
    else:
        b[r]=a[i]
        r+=1
for index,item in enumerate(b):
    if(index==len(b)-1):
        break
    sys.stdout.write(str(item)+" ")
sys.stdout.write(str(b[N-1])+"\n")
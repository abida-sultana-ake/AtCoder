t=int(input())
n=int(input())
a=list(map(int,input().split(" ")))
m=int(input())
b=list(map(int,input().split(" ")))
flag=0
if n<m:
    flag=1
aa=0
bb=0

while True:
    if a[aa]+t>=b[bb] and b[bb]>=a[aa]:
        aa+=1
        bb+=1
        if aa==n:
            if bb==m:
                break
            flag=1
            break
        if bb==m:
            break
    else :
        aa+=1
        if aa==n:
            flag=1
            break

if flag==0:
    print("yes")
else:
    print("no")
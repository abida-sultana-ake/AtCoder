n=int(input())
a=list(map(int,input().split(" ")))

a.insert(0,-1)

m=len(a)-1
res=""

k=m
for i in range(int(m/2)+1):
    res+=str(a[k])+" "
    k-=2
    if k<=0:
        break

if m%2==0:
    s=1
else:
    s=2

if m>1:
    k=s
    for i in range(int(m/2)+1):
        res+=str(a[k])+" "
        k+=2
        if k>=m:
            break

print(res)

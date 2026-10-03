n=int(input())
c=str(input())
lres=0
sres=1000000
for i in [1,2,3,4]:
    cnt=0
    for j in c:
        cnt+=(int(j)==i)
    lres=max(lres,cnt)
    sres=min(sres,cnt)

print(str(lres) +" "+str(sres))

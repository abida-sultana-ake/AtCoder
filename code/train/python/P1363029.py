n=int(input())
lis=list()

for var in range(1,n+1):
    num=int(input())
    lis.append(num)

lis.sort()
if sum(lis)%10==0:
    for var in range(0, len(lis)):
        if lis[var] % 10 != 0:
            m=lis[var]
            break
        else:
            m=None
    if m==None:
        print("0")
    else:
        s=sum(lis)-m
        print(s)
else:
    print(sum(lis))
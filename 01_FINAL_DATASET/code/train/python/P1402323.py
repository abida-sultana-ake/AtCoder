def p(b):
    for i in range(0,len(b)):
        if i==len(b)-1:
            print(b[i])
        else:
            print(b[i],' ',end="")

n=int(input())
a=[int(i) for i in input().split()]
b=[None]*n
if n%2==1:
    m=int(n/2)
    b[m]=a[0]
    s=1
    t=1
    while s+m<n:
        b[m+s]=a[t]
        t+=1
        b[m-s]=a[t]
        t+=1
        s+=1
    p(b)
else:
    m=int(n/2)
    b[m]=a[0]
    s=1
    t=1
    while s+m<=n:
        b[m-s]=a[t]
        t+=1
        if m-s==0:
            break
        b[m+s]=a[t]
        t+=1
        s+=1
    p(b)

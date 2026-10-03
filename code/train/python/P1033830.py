a=int(raw_input())
aa=a*a
aa1=(a+1)*(a+1)
laa=len(str(aa))
for i in xrange(laa+1+(laa+1)%2,-1,-2):
    n1=aa/10**i
    n2=n1+1
    if aa<=n1*10**i<aa1:
        print(n1)
        exit()
    if aa<=n2*10**i<aa1:
        print(n2)
        exit()

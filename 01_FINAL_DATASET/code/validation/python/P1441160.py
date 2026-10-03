n,m=map(int,input().split())
if abs(n-m)>1:
    print(0)
elif n==m:
    prod=1
    for i in range(1,n+1):
        prod*=i
        prod%=1000000007
    print(prod*prod*2%1000000007)
else:
    prod=1
    for i in range(1,min(m,n)+1):
        prod*=i
        prod%=1000000007
    print(prod*prod*max(m,n)%1000000007)

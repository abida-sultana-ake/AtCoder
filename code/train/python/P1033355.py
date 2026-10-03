from collections import defaultdict
n=int(input())
arr=list(map(int,input().split()))
dd=defaultdict(int)
for a in arr:
    dd[a]+=1
if n%2==0:
    for i in range(1,n,2):
        if dd[i]!=2:
            print(0)
            exit(0)
    else:
        prod=1
        for i in range(n//2):
            prod*=2
            prod%=1000000007
        print(prod)
else:
    if dd[0]!=1:
        print(0)
        exit(0)
    for i in range(2,n,2):
        if dd[i]!=2:
            print(0)
            exit(0)
    else:
        prod=1
        for i in range((n-1)//2):
            prod*=2
            prod%=1000000007
        print(prod)

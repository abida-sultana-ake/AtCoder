import math
n=int(input())

a=list(map(int,input().split()))

mi=2*(10**9)
for i in range(1,n):
    a[i]+=a[i-1]

tot=a[-1]
for i in a[:-1]:
    if int(math.fabs(tot-2*i))<mi:
        mi=int(math.fabs(tot-2*i))

print(mi)

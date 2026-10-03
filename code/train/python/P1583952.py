import math
 
N = int(input())
a = [int(input()) for i in range(N)]
sum = 0
a.sort()
a.reverse()
for i in range(0,len(a)):
    if i %2==0:
        sum+=a[i]*a[i]
    else:
         sum-=a[i]*a[i]
print("%f"%(math.pi*sum))
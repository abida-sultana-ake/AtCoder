import math
n=int(input())
a=[1000000]*(n+1)
for i in range(1,int(math.sqrt(n))+1):
    a[i]=abs(i-n//i)+n%i
print(min(a))

import math
n=input()
ans=float('inf')
for i in xrange(1,int(math.sqrt(n))+1):
    for j in xrange(int(math.sqrt(n)),n+1):
        if i*j>n:break
        ans=min(abs(i-j)+n-i*j,ans)
print(ans)
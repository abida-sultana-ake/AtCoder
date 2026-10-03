n=int(input())
a=(n+9)//10
for i in range(1,10):
        s=10**i;a+=(n//s+8)//10*s
        if (n//s)%10==1:a+=n%s+1
print(a)
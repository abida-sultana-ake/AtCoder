n=int(input())
a=list(map(int,input().split()))

total=sum(a)

ans=[]
x=0
for i in range(n-1):
    x+=a[i]
    y=total-x
    ans.append(abs(x-y))

print(min(ans))
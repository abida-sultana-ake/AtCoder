a,b=map(int,input().split())
res=1000000
for i in [-2,-1,0,1,2]:
    target=b%10+(a//10)*10+i*10
    res=min(res,abs(target-a)//5+abs(target-a)%5+abs(target-b)//10)
    if abs(target-a)<5:
        res=min(res,1+(-abs((target-a))%5+5)%5+abs(target-b)//10)
print(res)
a,b=map(int,input().split())
b=abs(b-a)

ans=0
ans+=int(b/10);
b=b%10;

if b == 1 or b ==5:
    ans +=1
elif b == 2 or b == 4 or  b == 6 or  b == 9:
    ans +=2
elif b == 3 or b == 7 or b == 8:
    ans +=3
print(ans)

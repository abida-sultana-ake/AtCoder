n=int(input())
ans=n
for x in range(1,n+1):
    ans=min(ans,abs(n//x-x)+n-x*(n//x))

print(ans)

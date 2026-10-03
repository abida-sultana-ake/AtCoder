n,a,b=map(int,raw_input().split())
x=map(int,raw_input().split())
ans=0
for i in xrange(n-1):
    if (x[i+1]-x[i])*a>=b:
        ans+=b
    else:
        ans+=a*(x[i+1]-x[i])
print(ans)

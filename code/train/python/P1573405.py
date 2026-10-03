n,h = map(int,input().split())
A,B,C,D,E = map(int,input().split())
ans = float('inf')
for x in range(n+1):
    y = max(0,((n-x)*E-h-x*B)//(D+E)+1)
    ans = min(ans,x*A+y*C)
print(ans)
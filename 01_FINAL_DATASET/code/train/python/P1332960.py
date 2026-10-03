n,a,b=map(int,input().split())
s=[int(input()) for _ in range(n)]
u=max(s)//b+1
l=0
while l+1<u:
    m=(u+l)//2
    if m<sum((max(h-b*m,0)+a-b-1)//(a-b) for h in s):
        l=m
    else:
        u=m
print(u)
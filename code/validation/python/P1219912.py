N,L=list(map(int,input().split()))
A=[list(input()) for _ in [1]*L]
y=list(input())

s=y.index('o')
for a in A[::-1]:
    if s>0:
        if a[s-1]=='-':
            s-=2
            continue
    if int(s/2+1)<N:
        if a[s+1]=='-':s+=2
        
print(int(s/2+1))
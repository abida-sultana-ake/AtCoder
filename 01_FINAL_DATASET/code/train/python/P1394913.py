n=int(input())
a=list(map(int,input().split()))
b1=[str(a[2*i]) for i in range(0,n//2)]
b2=[str(a[2*i+1]) for i in range(0,n//2)]
if n%2: b=[str(a[-1])]+list(reversed(b1))+b2
else: b=list(reversed(b2))+b1
print(" ".join(b))
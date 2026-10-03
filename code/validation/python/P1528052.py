n=int(input())
a=map(int, input().split())
a=sorted(a)[::-1]
k=-2
l=-2
for i in range(n-1):
    if (a[i]==a[i+1])&(i>k+1):
        if (k>=0):
            l=i
            break
        else:
            k=i
if l>=0:
    print(a[k]*a[l])
else:
    print(0)
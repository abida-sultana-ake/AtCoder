n=int(input())
a=[int(i) for i in input().split()]
a.sort()
f=True
if n%2==0:
    for i in range(n):
        if a[i]!=i//2*2+1:
            f=False
            break
else:
    for i in range(n):
        if a[i]!=(i+1)//2*2:
            f=False
            break
print(2**(n//2)%(10**9+7) if f else 0)

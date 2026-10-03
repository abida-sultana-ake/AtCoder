n=int(input())
a=[int(i) for i in input().split()]
a.sort()
i=n-1
s1=0
s2=0
while i>0:
    if a[i]==a[i-1] and s1==0:
        s1=a[i]
        i-=2
        continue
    if a[i]==a[i-1]:
        s2=a[i]
        i-=1
        break
    i-=1

print(s1*s2)
n=int(input())
MIN=1000
MAX=0
a=list(map(int,input().split()))
for i in range(n):
    if  MIN>a[i]:
        MIN=a[i]
    if MAX<a[i]:
        MAX=a[i]
print(MAX-MIN)
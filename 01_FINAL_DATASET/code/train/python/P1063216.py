n=int(input())
a=list(map(int,input().split()))
b=sorted(a)
if n%2==1:
    b=b[1:]

if n%2==0:
    for i in range(n):
        if b[i] != (i//2)*2+1:
            print(0)
            exit()
    else:
        print(2**(n//2) % (10**9+7))

if n%2==1:
    for i in range(n-1):
        if b[i] != (i//2)*2+2:
            print(0)
            exit()
    else:
        print(2**(n//2) % (10**9+7))
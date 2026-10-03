N=int(input())
a=list(map(int,input().split()))

B=0
C=0

S=sum(a)

T=S/N



if S%N!=0:
    print(-1)

else:
    for i in range(N):
        if a[i]==T:
            C=C+1

    if C==N:
        print(0)

    else:
        for i in range(N):
            if i==N-1:
                break
            elif a[i]>T:
                a[i+1]=a[i+1]-(T-a[i])
                a[i]=T
                B=B+1
            elif a[i]<T:
                a[i+1]=a[i+1]-(T-a[i])
                a[i]=T
                B=B+1
            else:
                pass
        print(B)
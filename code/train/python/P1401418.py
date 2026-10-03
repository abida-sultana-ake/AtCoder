n=int(input())
a=input().split()
for i in range(n):
        if n > 0: 
                print(a[n-1],end=" ")
                n=n-2
                if n == 0 or n == -1:
                        n=n-1
        elif n < 0: 
                print(a[-1*n-1],end=" ")
                n=n-2
print("")
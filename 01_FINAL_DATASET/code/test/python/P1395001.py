n=int(input())
a=input().split()

for i in range(len(a)):
    a[i]=int(a[i])

b=[0 for i in range(len(a))]

if(n%2==0):
    for i in range(int(n/2)):
        b[i]=a[n-2*i-1]
    
    for i in range(int(n/2)):
        b[i+int(n/2)]=a[1+2*i-1]
else:
    for i in range(int((n+1)/2)):
        b[i]=a[n-2*i-1]
    for i in range(int((n-1)/2)):
        b[i+int((n+1)/2)]=a[2+2*i-1]
        
for i in range(n):
    print(b[i],end=" ")
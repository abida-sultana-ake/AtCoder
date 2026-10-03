I=input;n,k=map(int,I().split())
a,b=int(I()),int(I())
for i in range(n-2):
    c=int(I())
    if a+b+c<k:print(i+3);exit()
    a,b=b,c
print(-1)
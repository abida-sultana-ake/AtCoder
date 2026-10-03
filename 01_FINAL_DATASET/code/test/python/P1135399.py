m,n,N=map(int,input().split())
s=N
while N//m>0:
 s+=N//m*n
 N=N//m*n+N%m
print(s)
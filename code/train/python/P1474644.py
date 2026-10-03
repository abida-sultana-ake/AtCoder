n,m = map(int,input().split())

if n>=12:
    n=n-12

N=n/12*360+m/720*360
M=m/60*360

A=abs(N-M)

if A>180:
    A=360-A

print(A)
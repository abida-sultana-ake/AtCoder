import math
N = input()
A = list(map(int, input().split()))

f,e,d = 0,0,0

for a in A:
    x = a % 4
    if(x==0):
        f = f+1
    elif(x==2):
        e = e+1
    else:
        d = d+1
if(e>0):
    d = d+1
if(f >= d-1):
    print("Yes")
else:
    print("No")
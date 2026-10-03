import math

N=int(input())
A=list(map(int,input().split()))

for i in range(N):
    if 0 in A:
        A.remove(0)

v=sum(A)/len(A)

b=math.ceil(v)

print(b)

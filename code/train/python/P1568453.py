a=[1,3,5,7,8,10,12]
b=[4,6,9,11]
c=[2]

x,y=map(int,input().split())

def jj(n):
        if n in a:
            return 1
        if n in b:
            return 2
        if n in c:
            return 3

if jj(x)==jj(y):
    print("Yes")
else:
    print("No")
A,T=input().split()

if A=='H' :
    a=1
else:
    a=0

if T=='H' :
    t=1
else:
    t=0

if a+t!=1:
    print('H')
else:
    print('D')

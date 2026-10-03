A, B =map(int,input().split())
C = A*B*(A+B)
if C%3==0:
    print('Possible')
else:
    print('Impossible')

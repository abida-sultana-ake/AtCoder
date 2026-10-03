import math
x,a,b = input().split()
x = int(x,10)
a = int(a,10)
b = int(b,10)
alpha = a - x
beta = b - x
alpha = math.fabs(alpha)
beta = math.fabs(beta)
if alpha > beta:
    print('B')
else:
    print('A')
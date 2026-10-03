import math
p=float(input())
x=math.log(3/(2*p*math.log(2)))/(-2*math.log(2)/3)

if x<0:
    print(p)
else:
    y=x+p/(2**(2*x/3))
    print(y)
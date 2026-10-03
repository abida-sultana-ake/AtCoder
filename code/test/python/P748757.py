import math

p = float(input())

x = -3/2*math.log( 3/2/p/math.log(2)  , 2)

if x > 0:
    y = x + p * pow( 2, -1* x / 1.5)
else:
    y = p

print(y)

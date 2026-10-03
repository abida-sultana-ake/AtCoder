import math
P = float(input())
xopt = 1.5 * math.log2(P*math.log(2)/1.5)
Popt = xopt + P*2**(-xopt/1.5)
if xopt > 0.0:
    print(Popt)
else:
    print(P)
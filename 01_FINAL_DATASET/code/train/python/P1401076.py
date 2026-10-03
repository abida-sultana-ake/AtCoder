
n,a,b = list(map(int, input().split()))
h = []
for i in range(n):
    h.append(int(input()))

import math as m

imin = 1
imax = sum([hh // a + 1 for hh in h])

while ( imax > imin+1 ):
    num = imin + (imax-imin)//2
    acnt = sum([m.ceil((hi- b*num)/(a-b)) for hi in h  if (hi- b*num)>0])
    if ( acnt<=num ):
        imax = num
    else:
        imin = num
print(imax)

#Reconciled?
import numpy as np
import math as mt
N,M = list(map(int, input().split()))
if(abs(N-M)>1):
    a=0
else:
    if (N==M):
        a = 2*mt.factorial(N)**2
    if (N!=M):
        a = mt.factorial(N)*mt.factorial(M)
print(a%(10**9+7))     
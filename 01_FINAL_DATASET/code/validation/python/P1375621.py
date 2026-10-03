# -*- coding: utf-8 -*-

import math

MAX = 1000000007

def ans(m,n):
    if ( abs(m - n) > 1 ):
        print(0);
        return 0

    if ( abs(m - n) == 1 ):
        print((math.factorial(m)*math.factorial(n))%MAX);
        return 0
    
    if ( abs(m - n) == 0 ):
        print((2*(math.factorial(m)*math.factorial(n)))%MAX);
        return 0

m,n = [int(i) for i in input().split()]
ans(m,n)

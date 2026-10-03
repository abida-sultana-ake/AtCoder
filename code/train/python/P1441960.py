# -*- coding:utf-8 -*-
import math
def isPrime(num):
    if num == 2:
        return True
    if num < 2 or num%2 == 0:
        return False
    for tmp in range(3, math.floor(math.sqrt(num))+1, 2):
        if num%tmp == 0:
            return False
    return True

def isPrime2(num):
    factor = list(map(int, list(str(num))))
    if sum(factor)%3 != 0 and factor[len(factor)-1]%2 != 0 and factor[len(factor)-1] != 5:
        return True
    else:
        return False

N = int(input())
if isPrime(N):
    print('Prime')
else:
    if isPrime2(N) and N != 1:
        print('Prime')
    else:
        print('Not Prime')
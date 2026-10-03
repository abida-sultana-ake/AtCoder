import functools
import sys
import math
from functools import reduce

input = lambda :sys.stdin.readline()
@functools.lru_cache(maxsize=10000)

def prime_numbers(limit=50001):
    yield 2
    sub_limit = int(limit**0.5)
    flags = [True, True] + [False] * (limit - 2)
    for i in range(3, limit, 2):
        if flags[i]:
            continue
        yield i

        if i <= sub_limit:
            for j in range(i*i, limit, i<<1):
                flags[j] = True

p=list(prime_numbers())


n=int(input())
d=[]
pr=1
for num in p:
    if num<=n:
        exp=1
        s=0
        while n>=num**exp:
            s+=int(n/(num**exp))
            exp+=1
        pr*=(s+1)
        # d.append(s)
    else:
        break
print (pr%1000000007)
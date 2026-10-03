import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

sys.setrecursionlimit(10**7)
inf = 10**10
mod = 10**9 + 7

def g(n,b):
    r = 0
    while n > 0:
        r += n % b
        n //= b
    return r

def f():
    n = int(input())
    s = int(input())
    if s == n:
        return n + 1
    sq = int(math.sqrt(n))
    for i in range(2,sq+1):
        if g(n, i) == s:
            return i
    if n % s == 0 and n//s > s:
        return n//s
    ns = n - s * 1.0
    for i in range(sq+1,0,-1):
        b = ns / i + 1
        if b != int(b) or b < 2:
            continue
        b = int(b)
        if g(n, b) == s:
            return b
    return -1

print(f())

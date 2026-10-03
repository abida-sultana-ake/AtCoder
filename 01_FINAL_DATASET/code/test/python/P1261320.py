import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time,copy,functools

sys.setrecursionlimit(10**7)
inf = 10**20
mod = 10**9 + 7

def LI(): return [int(x) for x in sys.stdin.readline().split()]
def LI_(): return [int(x)-1 for x in sys.stdin.readline().split()]
def LF(): return [float(x) for x in sys.stdin.readline().split()]
def LS(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def S(): return input()

def inv(a):
    n = mod - 2
    r = 1
    while n > 0:
        if n % 2 == 1:
            r = r * a % mod
        a = a * a % mod
        n >>= 1
    return r

def nCb(n, b):
    if b > n - b:
        b = n - b
    r = 1
    for k in range(n, n-b, -1):
        r = r * k % mod
    d = 1
    for k in range(1, b+1):
        d = d * k % mod
    return r * inv(d) % mod

def main():
    n,k = LI()
    if k >= n:
        return nCb(n,k%n)

    return nCb(n+k-1,k)


print(main())

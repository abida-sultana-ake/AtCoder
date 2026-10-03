import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time,copy,functools

sys.setrecursionlimit(10**7)
inf = 10**20
gosa = 1.0 / 10**10
mod = 10**9 + 7

def LI(): return [int(x) for x in sys.stdin.readline().split()]
def LI_(): return [int(x)-1 for x in sys.stdin.readline().split()]
def LF(): return [float(x) for x in sys.stdin.readline().split()]
def LS(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def S(): return input()

def inv(x):
    return pow(x, mod - 2, mod)

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
    h,w,a,b = LI()
    c1 = nCb(h-a-1+b, b)
    c2 = nCb(w-b-1+a, a)
    r = 0
    for i in range(1, min(h-a, w-b)+1):
        r += c1 * c2
        r %= mod
        c1 = c1 * (h-a-i) * inv(b+i) % mod
        c2 = c2 * (w-b-i) * inv(a+i) % mod

    return r

print(main())


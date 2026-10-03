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


m = {}
def kai(n):
    if n < 2:
        return 1
    if n in m:
        return m[n]
    m[n] = kai(n-1) * n % mod
    return m[n]

def main():
    n = I()
    a = sorted([I() for _ in range(n)])
    r = 0
    c = 0
    d = collections.defaultdict(int)
    for b in a:
        r += b+c
        c += b
        d[b] += 1

    c = 1
    for t in d.values():
        c *= kai(t)
        c %= mod

    return '{}\n{}'.format(r,c)




print(main())

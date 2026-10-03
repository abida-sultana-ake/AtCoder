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

def main():
    n = I()
    a = LI()
    if a[0] != 0:
        return 0
    am = max(a)

    d = [0] * (am+1)
    for c in a:
        d[c] += 1

    if d[0] > 1:
        return 0

    for i in range(am+1):
        if d[i] == 0:
            return 0

    r = 1
    b = 1
    for v in d[1:]:
        if v > 1:
            r *= pow(2, (v*(v-1)//2), mod)
            r %= mod
        r *= pow((2**b - 1) % mod, v, mod)
        r %= mod
        b = v
    return r


print(main())

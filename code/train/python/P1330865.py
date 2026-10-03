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

def bs(f, mi, ma):
    mm = -1
    while ma > mi:
        mm = (ma+mi) // 2
        if f(mm):
            mi = mm + 1
        else:
            ma = mm
    if f(mm):
        return mm + 1
    return mm

def main():
    n,a,b = LI()
    ab = a - b
    h = sorted([I() for _ in range(n)], reverse=True)
    def ff(t):
        bt = b*t
        c = 0
        for w in h:
            if w <= bt:
                return False
            c += (w - bt + ab - 1) // ab
            if c > t:
                return True
        return False

    return bs(ff, 0, sum(h) // b + 1)



print(main())

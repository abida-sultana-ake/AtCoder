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
    a = [I() for _ in range(n)]
    t = 1
    l = 1
    r = 0
    m = 1
    for i in range(1,n):
        if a[i-1] > a[i]:
            if m == 1:
                m = 2
                r = 1
            else:
                r += 1
        else:
            if m == 1:
                l += 1
            else:
                m = 1
                l = 2
                r = 0
        if t < l+r:
            t = l+r
    return t


print(main())

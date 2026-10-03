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
    N,K = LI()
    r = 0
    t = -1
    k = 0
    if K == 1:
        return N
    for _ in range(N):
        c = I()
        if c <= t:
            k = 1
            t = c
        else:
            k += 1
            if k >= K:
                r += 1
            t = c

    return r


print(main())







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
    N,M = sorted(LI())
    if abs(N-M) > 1:
        return 0
    nr = 1
    for i in range(2,N+1):
        nr *= i
        nr %= mod
    if N == M:
        nr = nr * nr
        nr %= mod
        nr *= 2
        nr %= mod
        r = nr
    else:
        mr = nr * M
        mr %= mod
        r = nr * mr
        r %= mod

    return r

print(main())







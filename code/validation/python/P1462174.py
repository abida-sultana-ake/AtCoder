import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time,copy,functools

sys.setrecursionlimit(10**7)
inf = 10**20
gosa = 1.0 / 10**9
mod = 10**9 + 7

def LI(): return [int(x) for x in sys.stdin.readline().split()]
def LI_(): return [int(x)-1 for x in sys.stdin.readline().split()]
def LF(): return [float(x) for x in sys.stdin.readline().split()]
def LS(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def S(): return input()


def main():
    N,M = LI()
    a = [LI() for _ in range(M)]
    t = set()
    s = set()
    for i,j in a:
        if i==1:
            t.add(j)
        elif i==N:
            s.add(j)
        if j==1:
            t.add(i)
        elif j==N:
            s.add(i)
    if t&s:
        return 'POSSIBLE'

    return 'IMPOSSIBLE'



print(main())


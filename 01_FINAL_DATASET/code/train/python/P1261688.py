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
    n,m = LI()
    a = [-1] * n
    d = collections.defaultdict(set)
    for _ in range(m):
        u,v = LI_()
        d[u].add(v)
        d[v].add(u)

    def f(i,k):
        a[i] = k

        ff = True
        for c in d[i]:
            if a[c] < 0:
                if not f(c, k+1):
                    ff = False
            elif k - a[c] != 1:
                ff = False
        return ff

    r = 0
    for i in range(n):
        if a[i] < 0 and f(i,1):
            r += 1

    return r


print(main())

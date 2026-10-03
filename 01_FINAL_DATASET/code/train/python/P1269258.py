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
    n,x = LI()
    h = LI()
    d = collections.defaultdict(set)
    for _ in range(n-1):
        a,b = LI_()
        d[a].add(b)
        d[b].add(a)

    def f(s,m):
        n = d[s] - set([m])
        t = 0
        for c in n:
            cf,ct = f(c,s)
            if cf:
                t += ct + 1
        if h[s] == 1 or t > 0:
            return [True, t]
        return [False, 0]

    xf,xt = f(x-1,-1)
    return xt * 2

print(main())

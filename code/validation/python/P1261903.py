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
    d = collections.defaultdict(set)
    for _ in range(m):
        a,b = LI_()
        d[a].add(b)
        d[b].add(a)

    f = [False] * n
    r = -1
    def g(i):
        if f[i]:
            return

        f[i] = True
        for c in d[i]:
            g(c)

    for i in range(n):
        if f[i]:
            continue
        g(i)
        r += 1

    return r


print(main())

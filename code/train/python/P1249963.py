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
    n,W = LI()
    a = [LI() for _ in range(n)]
    r = 0
    d = collections.defaultdict(int)
    d[0] = 0
    for w,v in a:
        for e,f in sorted(list(d.items()), key=lambda x: -x[0]):
            if e+w > W:
                continue
            if d[e+w] < d[e] + v:
                d[e+w] = d[e] + v

    return max(d.values())


print(main())

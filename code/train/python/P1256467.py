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
    a = [LI() for _ in range(n)]
    d = collections.defaultdict(lambda: collections.defaultdict(int))
    for r,h in a:
        d[r][h-1] += 1
    l = sorted(d.items())
    c = 0
    for r, rd in l:
        rv = sum(rd.values())
        rd[3] = rv
        rd[4] = c
        c += rv

    rr = []
    for r,h in a:
        rd = d[r]
        x = rd[4]+rd[h%3]
        z = rd[h-1]-1
        y = n - x - z - 1
        rr.append('{} {} {}'.format(x,y,z))

    return '\n'.join(rr)


print(main())

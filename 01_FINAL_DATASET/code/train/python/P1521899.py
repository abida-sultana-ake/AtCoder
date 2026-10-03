import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time,copy,functools

sys.setrecursionlimit(10**7)
inf = 10**20
gosa = 1.0 / 10**10
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
    a = LI()
    d = collections.defaultdict(int)
    for c in a:
        d[c] += 1
    r = []
    for k,v in sorted(d.items(),reverse=True):
        if v >= 4:
            r.append(k)
            r.append(k)
            break
        elif v >= 2:
            r.append(k)
            if len(r) > 1:
                break
    if len(r) > 1:
        return r[0] * r[1]

    return 0

print(main())


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
    n,a,b = LI()
    s = [I() for _ in range(n)]
    sa = max(s)
    si = min(s)
    if sa-si == 0:
        if b != 0:
            return -1
        return '{} {}'.format(0,a)
    p = b / (sa-si)
    q = a - sum(c*p for c in s) / len(s)
    return '{} {}'.format(p,q)


print(main())

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
    N,C = LI()
    a = collections.defaultdict(int)
    b = collections.defaultdict(int)
    for i in range(N):
        c = I()
        if i % 2 == 0:
            a[c] += 1
        else:
            b[c] += 1

    r = N
    for ak,av in a.items():
        tr = N - av
        if tr < r:
            r = tr
        for bk,bv in b.items():
            if bk == ak:
                continue
            br = tr - bv
            if r > br:
                r = br

    return r * C


print(main())







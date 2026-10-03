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
    w,h = LI()
    n = I()
    a = [LI() for _ in range(n)]

    m = {}
    def s(i,j,k,l):
        if i > k or j > l:
            return 0
        key = (i,j,k,l)
        if key in m:
            return m[key]

        r = 0
        for x,y in a:
            if i <= x <= k and j <= y <= l:
                tr = (k-i) + (l-j) + 1
                tr += s(i, j, x-1, y-1)
                tr += s(x+1, j, k, y-1)
                tr += s(i, y+1, x-1, l)
                tr += s(x+1, y+1, k, l)
                if r < tr:
                    r = tr
        m[key] = r
        return r

    res = s(1,1,w,h)

    return res


print(main())

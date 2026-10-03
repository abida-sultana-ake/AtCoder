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
    n,k = LI()
    a = LI()
    b = [(a[i],i+1) for i in range(n)]
    ra = sorted(b)
    ii = [None] * (n+1)
    for i in range(n):
        ii[ra[i][1]] = i
    ti = k-1
    r = [ra[ti][1]]
    for i in range(n-1,k-1,-1):
        c = b[i][1]
        if ii[c] <= ti:
            ti += 1
            while ra[ti][1] > c:
                ti += 1
        r.append(ra[ti][1])

    return '\n'.join(map(str, r[::-1]))


print(main())

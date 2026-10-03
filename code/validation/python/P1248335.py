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

# binary search
def bs(f, mi, ma):
    mm = -1
    while ma > mi:
        mm = (ma+mi) // 2
        if f(mm):
            mi = mm + 1
        else:
            ma = mm
    if f(mm):
        return mm + 1
    return mm

def main():
    n = I()
    a = [I() for _ in range(n)]
    r = [-inf] + [inf] * (n+1)
    r[1] = a[0]
    m = 2
    for c in a[1:]:
        def f(x):
            return r[x] < c
        t = bs(f,0,m)
        if r[t] > c:
            r[t] = c
        if t >= m:
            m = t+1

    return n - m + 1


print(main())

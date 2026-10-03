import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time,copy

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
    a = LI()
    r = 0
    c = 0
    for i in range(n):
        t = a[i]
        if i%2 == 0:
            if c+t > 0:
                c += t
            else:
                r += 1 - (c+t)
                c = 1
        else:
            if c+t < 0:
                c += t
            else:
                r -= -1 - (c+t)
                c = -1
    r2 = 0
    c = 0
    for i in range(n):
        t = a[i]
        if i%2 == 1:
            if c+t > 0:
                c += t
            else:
                r2 += 1 - (c+t)
                c = 1
        else:
            if c+t < 0:
                c += t
            else:
                r2 -= -1 - (c+t)
                c = -1

    return min(r,r2)


print(main())

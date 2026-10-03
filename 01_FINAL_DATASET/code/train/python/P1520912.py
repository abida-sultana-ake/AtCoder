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
    a = [0] * 366
    for i in range(366):
        if (i % 7) in [0,6]:
            a[i] = 1

    t = [31,29,31,30,31,30,31,31,30,31,30,31]
    def f(m,d):
        n = d - 1
        for i in range(m-1):
            n += t[i]
        return n

    for _ in range(n):
        m,d = [int(x) for x in sys.stdin.readline().split('/')]
        k = f(m,d)
        for i in range(k,366):
            if a[i] == 0:
                a[i] = 1
                break
    r = 2
    c = 0
    a.append(0)
    for i in range(367):
        k = a[i]
        if k == 0:
            if r < c:
                r = c
            c = 0
        else:
            c += 1

    return r


print(main())


import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time,copy,functools

sys.setrecursionlimit(10**7)
inf = 10**20
gosa = 1.0 / 10**9
mod = 10**9 + 7

def LI(): return [int(x) for x in sys.stdin.readline().split()]
def LI_(): return [int(x)-1 for x in sys.stdin.readline().split()]
def LF(): return [float(x) for x in sys.stdin.readline().split()]
def LS(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def S(): return input()


def main():
    h,w = LI()
    n = I()
    a = LI()

    r = [0] * (h*w)
    t = 0
    for i in range(1,n+1):
        c = a[i-1]
        for j in range(c):
            r[t+j] = i
        t += c
    rr = []
    for i in range(h):
        t = r[i*w:i*w+w]
        if i % 2 == 1:
            t.reverse()
        rr.append(t)

    return '\n'.join([' '.join(map(str, r)) for r in rr])



print(main())


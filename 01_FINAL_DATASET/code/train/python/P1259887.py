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
    n,m = LI()
    a = [I() for _ in range(m)]
    f = [False] * (n+1)
    rr = []
    for c in a[::-1]:
        if f[c]:
            continue
        rr.append(c)
        f[c] = True
    for i in range(1,n+1):
        if f[i]:
            continue
        rr.append(i)

    return '\n'.join(map(str, rr))


print(main())

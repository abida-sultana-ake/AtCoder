import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

sys.setrecursionlimit(10**7)
inf = 10**20
mod = 10**9 + 7

def LI(): return [int(x) for x in sys.stdin.readline().split()]
def LF(): return [float(x) for x in sys.stdin.readline().split()]
def LS(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def S(): return input()


def main():
    n,m = LI()
    a = [0] + [I() for _ in range(n)]
    r = [0] * (n+1)
    r[0] = 1
    la = [0] * (m+1)
    l = 0
    ls = 1
    for i in range(1,n+1):
        if l < la[a[i]]:
            for j in range(l,la[a[i]]):
                ls -= r[j]
            l = la[a[i]]

        la[a[i]] = i
        r[i] = ls
        ls += r[i]
        ls %= mod
        r[i] %= mod

    return r[-1]


print(main())

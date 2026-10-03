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
    n,m,d = LI()
    a = list(range(n))
    for i in LI()[::-1]:
        a[i],a[i-1] = a[i-1],a[i]

    r = list(range(n))

    while d > 0:
        if d % 2 == 1:
            for i in range(n):
                r[i] = a[r[i]]

        a = [a[a[i]] for i in range(n)]

        d //= 2


    return '\n'.join(map(lambda x: str(x+1), r))

print(main())

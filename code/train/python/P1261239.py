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
    n = I()
    r = 0
    b = 0
    for _ in range(n):
        for c in S():
            if c == 'R':
                r += 1
            elif c == 'B':
                b += 1

    if r > b:
        return 'TAKAHASHI'
    if b > r:
        return 'AOKI'

    return 'DRAW'


print(main())

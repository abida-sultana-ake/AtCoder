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
    L,R = LI()
    a = LI()
    b = LI()
    r = 0
    d = collections.defaultdict(int)
    for c in a:
        d[c] += 1

    for c in b:
        if d[c] < 1:
            continue
        r += 1
        d[c] -= 1


    return r


print(main())

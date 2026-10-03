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
    s = [I() for _ in range(n)]
    t = [0] * 10001
    t[0] = 1
    for c in s:
        for i in range(10000,c-1,-1):
            t[i] += t[i-c]

    for i in range(10000,c-1,-1):
        if i % 10 == 0:
            continue
        if t[i] > 0:
            return i

    return 0


print(main())

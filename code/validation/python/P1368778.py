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
    a = [I() for _ in range(n)]
    s = set(a)
    if len(s) == 1:
        return -1

    a = a + a
    m = 0
    c = 0
    t = -1
    for i in a:
        if i != t:
            if m < c:
                m = c
            t = i
            c = 1
        else:
            c += 1

    return (m+1) // 2


print(main())

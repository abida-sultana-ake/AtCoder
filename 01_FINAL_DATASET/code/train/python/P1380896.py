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
    s = S()
    l = len(s)
    c = 0
    t = -1
    for i in range(l//2):
        if s[i] != s[-(i+1)]:
            c += 1
            t = i
    if c == 0:
        return 25 * (l//2) * 2
    if c == 1:
        r = 25 * (l//2-1) * 2
        if l % 2 == 1:
            r += 25
        r += 24 * 2
        return r

    return 25 * l


print(main())







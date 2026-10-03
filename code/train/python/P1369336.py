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
    N = I()
    a = LI()
    d = collections.defaultdict(int)
    i = 0
    r = 0
    for j in range(N):
        c = a[j]
        if d[c] == 1:
            t = j - i
            if r < t:
                r = t
            while a[i] != c:
                d[a[i]] -= 1
                i += 1
            i += 1
        else:
            d[c] += 1
    t = N - i
    if r < t:
        r = t

    return r

print(main())







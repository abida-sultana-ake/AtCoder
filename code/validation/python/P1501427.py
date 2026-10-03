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
    n = I()
    a = LI()
    d = collections.defaultdict(int)
    for c in a:
        d[c%4] += 1

    d[1] += d[3]
    if d[2] == 1:
        d[1] += 1
    if (d[1] == 0) or (d[1] - (1 if d[2] < 2 else 0) <= d[0] and d[0] > 0):
        return 'Yes'

    return 'No'



print(main())


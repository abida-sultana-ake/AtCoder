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
    nn = (n+1)*n // 2
    if n == 1:
        return 'BOWWOW'
    if nn % 2 == 0:
        return 'BOWWOW'
    for i in range(3,n,2):
        if nn % i == 0:
            return 'BOWWOW'

    return 'WANWAN'


print(main())

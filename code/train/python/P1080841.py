import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

sys.setrecursionlimit(10**7)
inf = 10**20
mod = 10**9 + 7

def LI(): return list(map(int, input().split()))
def II(): return int(input())
def LS(): return input().split()
def S(): return input()


def main():
    n = II()
    r = n // 11 * 2
    t = n % 11
    if t == 0:
        return r
    if t < 7:
        return r+1
    return r+2


print(main())

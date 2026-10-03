import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

sys.setrecursionlimit(10**7)
inf = 10**20
mod = 10**9 + 7

def LI(): return list(map(int, input().split()))
def LF(): return list(map(float, input().split()))
def II(): return int(input())
def LS(): return input().split()
def S(): return input()


def main():
    n,m = LI()
    b = [0] * n
    for _ in range(m):
        x,y = LI()
        b[x-1] |= 2**(y-1)
    a = [0] * (2**n)
    a[0] = 1
    ii = [[i,2**i] for i in range(n)]
    for i in range(2**n-1):
        if a[i] < 1:
            continue
        for j,bj in ii:
            if i & bj or i & b[j]:
                continue
            a[i+bj] += a[i]
    return a[-1]

print(main())

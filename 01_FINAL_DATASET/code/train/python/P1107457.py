import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

sys.setrecursionlimit(10**7)
inf = 10**20
mod = 10**9 + 7

def LI(): return list(map(int, input().split()))
def II(): return int(input())
def LS(): return input().split()
def S(): return input()


def main():
    n,m = LI()
    a = []
    for i in range(n):
        t = 0
        for c in S():
            t <<= 1
            if c == '#':
                t += 1
        a.append(t)

    b = []
    for i in range(m):
        t = 0
        for c in S():
            t <<= 1
            if c == '#':
                t += 1
        b.append(t)

    mask = 2**m-1
    for i in range(n-m+1):
        for j in range(n-m+1):
            f = True
            for k in range(m):
                ak = (a[k+j] >> i) & mask
                if ak != b[k]:
                    f = False
                    break
            if f:
                return 'Yes'
    return 'No'


print(main())

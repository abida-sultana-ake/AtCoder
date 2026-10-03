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
    n,m = LI()
    b = [[int(c) for c in S()] for _ in range(n)]
    a = [[0]*m for _ in range(n)]
    for i in range(n):
        bi = b[i]
        for j in range(m):
            bij = bi[j]
            if bij < 1:
                continue
            b[i+2][j] -= bij
            b[i+1][j-1] -= bij
            b[i+1][j+1] -= bij
            a[i+1][j] = bij

    return '\n'.join(''.join(map(str, t)) for t in a)


print(main())

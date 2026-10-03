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
    a = [LI_() for i in range(m)]
    o = [0]*(n+1)
    for s,t in a:
        o[s] += 1
        o[t+1] -= 1

    for i in range(1,n+1):
        o[i] += o[i-1]

    for i in range(n+1):
        if o[i] > 1:
            o[i] = 0

    for i in range(1,n+1):
        o[i] += o[i-1]

    o = [0] + o
    r = []
    for i in range(m):
        s,t = a[i]
        if o[t+1] == o[s]:
            r.append(i+1)

    return '\n'.join(map(str, [len(r)] + r))


print(main())

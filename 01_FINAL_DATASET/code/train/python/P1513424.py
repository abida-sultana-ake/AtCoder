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


class Flow():
    def __init__(self, e, N):
        self.E = e
        self.N = N

    def max_flow(self, s, t):
        r = 0
        e = self.E

        def f(c):
            v = self.v
            v[c] = 1
            if c == t:
                return 1
            for i in range(self.N):
                if v[i] == 0 and e[c][i] > 0 and f(i) > 0:
                    e[c][i] -= 1
                    e[i][c] += 1
                    return 1
            return 0

        while True:
            self.v = [0] * self.N
            if f(s) == 0:
                break
            r += 1

        return r

def main():
    N,G,E = LI()
    p = LI()
    e = collections.defaultdict(lambda: collections.defaultdict(int))
    for _ in range(E):
        a,b = LI()
        e[a][b] += 1
        e[b][a] += 1

    for c in p:
        e[c][N+1] = 1

    f = Flow(e, N+2)

    r = f.max_flow(0, N+1)

    return r



print(main())


import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

sys.setrecursionlimit(10**7)
inf = 10**20
mod = 10**9 + 7

def LI(): return list(map(int, input().split()))
def LF(): return list(map(float, input().split()))
def II(): return int(input())
def LS(): return input().split()
def S(): return input()


class UnionFind:
    def __init__(self, size):
        self.table = [-1 for _ in range(size)]

    def find(self, x):
        if self.table[x] < 0:
            return x
        else:
            self.table[x] = self.find(self.table[x])
            return self.table[x]

    def union(self, x, y):
        s1 = self.find(x)
        s2 = self.find(y)
        if s1 != s2:
            if self.table[s1] <= self.table[s2]:
                self.table[s1] += self.table[s2]
                self.table[s2] = s1
            else:
                self.table[s2] += self.table[s1]
                self.table[s1] = s2


def main():
    n,m = LI()
    aa = [LI() for _ in range(m)]
    aa = sorted(aa, key=lambda x: -x[2])
    q = II()
    qa = [LI() + [_] for _ in range(q)]
    qa = sorted(qa, key=lambda x: -x[1])
    uf = UnionFind(n+1)
    r = [1] * q
    ay = aa[0][2]
    ai = 0
    for t0,y,t1 in qa:
        while ay > y:
            uf.union(aa[ai][0],aa[ai][1])
            if ai < m-1:
                ai += 1
                ay = aa[ai][2]
            else:
                ai = -1
                ay = -inf

        r[t1] = -uf.table[uf.find(t0)]

    return '\n'.join(map(str, r))

print(main())

import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

sys.setrecursionlimit(10**7)
inf = 10**10
mod = 10**9 + 7


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
            return True
        return False

    def subsetall(self):
        a = []
        for i in range(len(self.table)):
            if self.table[i] < 0:
                a.append((i, -self.table[i]))
        return a

def main():
    n,k,l = list(map(int, input().split()))
    uk = UnionFind(n)
    ul = UnionFind(n)
    for _ in range(k):
        p,q = list(map(int, input().split()))
        uk.union(p-1,q-1)
    for _ in range(l):
        p,q = list(map(int, input().split()))
        ul.union(p-1,q-1)

    sk = collections.defaultdict(set)
    sl = collections.defaultdict(set)
    m = {}

    for i in range(n):
        sk[uk.find(i)].add(i)
        sl[ul.find(i)].add(i)
    r = []
    for i in range(n):
        if i in m:
            r.append(m[i])
            continue
        ss = sk[uk.find(i)] & sl[ul.find(i)]
        ssl = len(ss)
        for sc in ss:
            m[sc] = ssl
        r.append(m[i])

    return " ".join(map(str, r))



print(main())

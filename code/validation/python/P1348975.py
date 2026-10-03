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

class Prime():
    def __init__(self, n):
        self.M = m = int(math.sqrt(n)) + 10
        self.A = a = [True] * m
        a[0] = a[1] = False
        self.T = t = []
        for i in range(2, int(math.sqrt(m)) + 1):
            if not a[i]:
                continue
            t.append(i)
            for j in range(i*i,m,i):
                a[j] = False

    def is_prime(self, n):
        return self.A[n]

    def division(self, n):
        d = collections.defaultdict(int)
        for c in self.T:
            while n % c == 0:
                d[c] += 1
                n //= c
            if n < 2:
                break
        if n > 1:
            d[n] += 1
        return d.items()

    def sowa(self, n):
        r = 1
        for k,v in self.division(n):
            t = 1
            for i in range(1,v+1):
                t += math.pow(k, i)
            r *= t
        return r

def main():
    n = I()
    pr = Prime(n)
    t = pr.sowa(n) - n
    if n == t:
        return 'Perfect'
    if n > t:
        return 'Deficient'

    return 'Abundant'


print(main())

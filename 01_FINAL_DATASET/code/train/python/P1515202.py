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


def main():
    a = [[c == 'Q' for c in S()] for _ in range(8)]
    t = [0] * 8
    y = [0] * 8
    n1 = [0] * 15
    n2 = [0] * 15

    for i in range(8):
        for j in range(8):
            if not a[i][j]:
                continue
            t[j] += 1
            y[i] += 1
            n1[i+j] += 1
            n2[i-j+7] += 1

    if max(max(t),max(y),max(n1),max(n2)) > 1:
        return 'No Answer'

    def f(i):
        if i == 8:
            return True

        if y[i] > 0:
            return f(i+1)

        for j in range(8):
            if t[j] + n1[i+j] + n2[i-j+7] > 0:
                continue
            t[j] = n1[i+j] = n2[i-j+7] = 1
            if f(i+1):
                a[i][j] = True
                return True
            t[j] = n1[i+j] = n2[i-j+7] = 0

    r = f(0)
    if r:
        return '\n'.join([''.join(['Q' if c else '.' for c in t]) for t in a])

    return 'No Answer'



print(main())


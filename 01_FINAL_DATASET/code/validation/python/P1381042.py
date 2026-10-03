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
    N = I()
    a = [''] * 9
    r = 0
    for _ in range(N):
        s = S()
        for i in range(9):
            c = s[i]
            if c == 'x':
                r += 1
                a[i] += '.'
            else:
                a[i] += s[i]
    for s in a:
        for c in re.sub('o+', 'x', s):
            if c == 'x':
                r += 1

    return r


print(main())







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
    L = I()
    b = [I() for _ in range(L)]
    a = [0] * L
    for i in range(1,L):
        a[i] = b[i-1] ^ a[i-1]

    if a[0] ^ a[-1] != b[-1]:
        return -1

    return '\n'.join(map(str,a))

print(main())







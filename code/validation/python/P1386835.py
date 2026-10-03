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
    n = I()
    s = LS()
    r = []
    for t in s:
        k = ''
        nc = 0
        for c in t.lower():
            if c in 'bc':
                k += '1'
            elif c in 'dw':
                k += '2'
            elif c in 'tj':
                k += '3'
            elif c in 'fq':
                k += '4'
            elif c in 'lv':
                k += '5'
            elif c in 'sx':
                k += '6'
            elif c in 'pm':
                k += '7'
            elif c in 'hk':
                k += '8'
            elif c in 'ng':
                k += '9'
            elif c in 'zr':
                k += '0'
            else:
                nc += 1
        if nc < len(t):
            r.append(str(k))

    return ' '.join(r)



print(main())




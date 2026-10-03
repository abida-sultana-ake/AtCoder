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
    n,r = LI()
    s = S()
    if '.' not in s:
        return 0
    ri = s.rindex('.')
    ei = ri - r + 1
    if ei < 0:
        return 1
    t = 0
    i = 0
    while i < ei:
        if s[i] == '.':
            t += 1
            if i+r >= ei:
                t += ei-i
                i = ei
            else:
                t += r
                i += r
            continue
        i += 1
        t += 1

    return t + 1


print(main())

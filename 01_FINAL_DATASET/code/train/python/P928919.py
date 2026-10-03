import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

sys.setrecursionlimit(10**7)
inf = 10**10
mod = 10**9 + 7

def f():
    s = input()
    r = 0
    tt = ['g','p']
    t = 'g'
    i = 0
    for c in s:
        if c != t:
            if t == 'p':
                r += 1
            else:
                r -=1
        i += 1
        t = tt[i%2]
    return r

print(f())

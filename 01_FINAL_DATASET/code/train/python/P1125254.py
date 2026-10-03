#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def readln():
    _res = list(map(int,str(input()).split(' ')))
    return _res

# mark sheep with 0, wolf with 1
# x -> 1, o -> 0
# si = ai-1^ai^ai+1

def cvt(c):
    if c == 'o':
        return 0
    else:
        return 1

def mxor(x1,x2,x3):
    return (x1+x2+x3) % 2

def test():
    a[n] = a[0]
    for i in range(2,n):
        a[i] = mxor(a[i-2],s[i-1],a[i-1])
    if a[0] != mxor(a[n-1],s[0],a[1]):
        return False
    if a[n-1] != mxor(a[n-2],s[n-1],a[n]):
        return False
    return True

def no_answer():
    for a[0] in range(0,2):
        for a[1] in range(0,2):
            if test():
                st = ""
                for x in range(0,n):
                    if a[x] == 0: st = st + 'S'
                    else: st = st + 'W'
                print(st)
                return False
    return True

n = int(input())
s = list(map(cvt,str(input())))
a = [0 for i in range(0,n+1)]
if no_answer():
    print(-1)

# [1, 0, 1, 1, 0, 1, 0, 1, 1, 0]

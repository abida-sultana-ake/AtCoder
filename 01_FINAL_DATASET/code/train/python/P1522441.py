#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from math import *
import random

def readln():
    return list(map(int,(input().split(" "))))

N = int(input())
A = sorted(readln())
x,y = 0,0
for i in range(1,N):
    if(A[i] == A[i-1]):
        y = x
        x = A[i]
        A[i] = 0
print(x*y)

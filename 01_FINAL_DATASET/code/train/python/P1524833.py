#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from math import *
import random

def readln():
    return list(map(int,(input().split(" "))))

def add(x,y):
    return (x + y) % 1000000007

N = int(input())
A = input()
B = input()

F = [0 for i in range(N)]
sum = [0 for i in range(N)]

F[0] = [[0 for j in range(3)] for i in range(3)]
if(A[0] == B[0]):
    for i in range(3):
        F[0][i][i] = 1
    sum[0] = 3
else:
    for i in range(3):
        for j in range(3):
            if(i != j):
                F[0][i][j] = 1
    sum[0] = 6

for idx in range(1,N):
    F[idx] = [[0 for j in range(3)] for i in range(3)]

    if(A[idx] == B[idx]):
        for i in range(3):
            for j in range(3):
                for k in range(3):
                    if((k != i) and (k != j)):
                        value = F[idx-1][i][j]
                        F[idx][k][k] = add(F[idx][k][k],value)
                        sum[idx] = add(sum[idx],value)
    else:
        if(A[idx] == A[idx-1]):
            for i in range(3):
                for j in range(3):
                    F[idx][i][j] = F[idx-1][i][j]
                    sum[idx] = sum[idx-1]
        else:
            for i in range(3):
                for j in range(3):
                    for k in range(3):
                        for l in range(3):
                            if((i != k) and (j != l) and (k != l)):
                                value = F[idx-1][i][j]
                                F[idx][k][l] = add(F[idx][k][l],value)
                                sum[idx] = add(sum[idx],value)
print(sum[N-1])

#!/bin/python
# coding: utf-8

li = list(map(int,input().split()))
def area(x,y):
    return x * y
 
A = area(li[0],li[1])
B = area(li[2],li[3])

if A > B:
    print(A)
else:
    print(B)

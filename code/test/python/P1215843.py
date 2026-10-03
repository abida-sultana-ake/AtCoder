#!/usr/bin/env python
#coding:utf-8

def input_strs():
    return input().split(" ")

def input_nums():
    return [int(i) for i in input_strs()]

n = int(input())
ss = [input() for i in range(n)]

a = 0
b = ""
for s in ss:
    p = 0
    for t in ss:
        if s == t:
            p += 1
    if a <= p:
        a = p
        b = s

print(b)

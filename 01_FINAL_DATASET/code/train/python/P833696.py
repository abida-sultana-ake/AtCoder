#! /usr/bin/env python
# coding: utf-8

R, B = map(int, input().split())
x, y = map(int, input().split())

right = max(R, B)
left = 0

def ok(f):
    if min(R, B) < f:
        return False
    a = (R - f) // (x - 1)
    b = (B - f) // (y - 1)
    return (a + b) >= f

while right > left + 1:
    f = (right + left) // 2
    if ok(f):
        left = f
    else:
        right = f
print(left)
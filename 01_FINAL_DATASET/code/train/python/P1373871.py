# -*- coding: utf-8 -*-

X, A, B = [int(x) for x in input().split()]

if A >= B:
    print("delicious")
elif (A + X) >= B:
    print("safe")
else:
    print("dangerous")

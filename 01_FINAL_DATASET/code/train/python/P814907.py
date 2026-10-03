#!/usr/bin/env python3
# -*- coding: utf-8 -*-

N,K = map(int,input().split())
D = set(input().split())

while True:
    N_str = str(N)
    if set(N_str) & D:
        N += 1
    else:
        break
print(N)


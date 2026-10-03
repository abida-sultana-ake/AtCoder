#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 解説に従い実装

N=int(input())

for i in range(N):
    ti,ai = map(int,input().split())
    if i == 0:
        t,a = ti,ai
    else:
        # t <= n * ti and a <= n * ai を満たす最小のnを求める
        n = max((t + ti - 1) // ti, (a + ai - 1) // ai)
        t = n * ti
        a = n * ai

print(a+t)

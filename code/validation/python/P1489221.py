# -*- coding: utf-8 -*-
"""
Created on Sun Aug  6 21:37:48 2017

@author: syaga
"""

if __name__ == "__main__":
    H, W = list(map(int, input().split()))
    N = int(input())
    a = list(map(int, input().split()))
    lis = [[None]*W for i in range(H)]
    ins = 1
    for i in range(H):
        for j in range(W):
            if a[0] == 0:
                del a[0]
                ins += 1
            lis[i][j] = ins
            a[0] -= 1
    for i in range(H//2):
        lis[2*i+1].reverse()
    for i in lis:
        print(" ".join(map(str, i)))

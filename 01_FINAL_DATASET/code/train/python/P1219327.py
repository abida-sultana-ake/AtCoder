# -*- coding: utf-8 -*-

import sys
import os


N = int(input())
s = list(input())

def judge(X):
    for i in range(1, N - 1):
        left = X[i - 1]

        if X[i] == 0:
            if s[i] == 'o':
                right = left
            else:
                right = 1 - left
        else:
            if s[i] == 'o':
                right = 1 - left
            else:
                right = left
        X.append(right)

    # 全体で確認
    is_consistent = True
    for i in range(N):
        left = X[i-1]
        if i+1 <= N-1:
            right = X[i + 1]
        else:
            right = X[i + 1 - N]

        if X[i] == 0:
            if s[i] == 'o':
                if left != right:
                    is_consistent = False
            else:
                if left == right:
                    is_consistent = False
        else:
            if s[i] == 'o':
                if left == right:
                    is_consistent = False
            else:
                if left != right:
                    is_consistent = False
    return is_consistent, X

# 0: sheep
# 1: wolf
X_list = [[0, 0], [0, 1], [1, 0], [1, 1]]

results = []
for X in X_list:
    results.append(judge(X))

trues = [result for result in results if result[0] is True]
if trues:
    result = trues[0]
    X = result[1]
    for x in X:
        if x == 0:
            print('S', end='')
        else:
            print('W', end='')
    print()
else:
    print(-1)
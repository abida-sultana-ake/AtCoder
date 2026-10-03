# -*- coding:utf-8 -*-
import sys
S, T = (input(), input())
for num in range(len(S)):
    flag = 0
    if S[num] != T[num]:
        for tmp in ['a','t','c','o','d','e','r']:
            if (S[num] == '@' and T[num] == tmp) or (T[num] == '@' and S[num] == tmp):
                flag = 1
                break
        if flag != 1:
            print('You will lose')
            sys.exit()
print('You can win')
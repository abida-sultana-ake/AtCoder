# -*- coding:utf-8 -*-
N = list(input())
if ''.join(N) == ''.join(reversed(N)):
    print('Yes')
else:
    print('No')
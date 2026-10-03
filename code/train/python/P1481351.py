# -*- coding:utf-8 -*-
S = list(input())
a = { 'O':'0', 'D':'0', 'I':'1', 'Z':'2', 'S':'5', 'B':'8' }
for tmp in range(len(S)):
    if S[tmp] in a:
        S[tmp] = a[S[tmp]]
    else:
        pass
print(''.join(S))
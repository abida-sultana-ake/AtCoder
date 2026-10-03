# -*- coding:utf-8 -*-
S = list(map(str, input().split()))
a = []
for tmp in S:
    if tmp == "Left":
        a.append('<')
    elif tmp == "Right":
        a.append('>')
    else:
        a.append('A')
print(' '.join(a))
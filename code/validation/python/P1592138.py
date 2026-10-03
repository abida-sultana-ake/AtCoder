# -*- coding:utf-8 -*-
s = list(input())
flag = True
for tmp in range(len(s)//2):
    if s[tmp] != s[(len(s)-1)-tmp]:
        if s[tmp] == '*' or s[(len(s)-1)-tmp] == '*':
            pass
        else:
            flag = False
            break
if flag:
    print("YES")
else:
    print("NO")
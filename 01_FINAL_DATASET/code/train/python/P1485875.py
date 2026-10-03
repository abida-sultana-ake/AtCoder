#! -*- coding:utf-8 -*-
s = str(input())
x = list(s)

e = x.pop()
a = x.pop(0)

print(a,len(x),e,sep='')

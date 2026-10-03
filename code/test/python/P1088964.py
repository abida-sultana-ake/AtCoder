# -*- coding:utf-8 -*-
expression = input().split()
if expression[1] == "+":
    print(int(expression[0]) + int(expression[2]))
else:
    print(int(expression[0]) - int(expression[2]))
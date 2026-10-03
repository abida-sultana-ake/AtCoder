# -*- coding: utf-8 -*-
x = int(input())
y = input()

z = y

while z.find("()") != -1:
    z = z.replace("()","")

a = z.count("(")
b = z.count(")")

ans = y

for i in range(a):
    ans = ans + ")"

for i in range(b):
    ans = "(" + ans

print(ans)

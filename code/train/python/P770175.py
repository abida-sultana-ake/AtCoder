# _*_ coding: utf-8 _*_

inputL = raw_input()

x = int(inputL)
n = 1

while n <= x:
    if n**4 == x:
        print(n)
        break
    else:
        n += 1
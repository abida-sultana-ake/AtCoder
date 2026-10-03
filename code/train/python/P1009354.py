import math
st = input().split()
a = int(st[0])
b = int(st[1])
x = int(st[2])

ret = b//x - a//x
if a%x == 0:
    ret += 1

print(ret)
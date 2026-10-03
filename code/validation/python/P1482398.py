# -*- coding:utf-8 -*-
E = list(input().split())
B = input()
L = list(input().split())
factor = 0
for tmp in E:
    if tmp in L:
        L.pop(L.index(tmp))
        factor += 1
    else:
        pass
if factor == 6:
    print(1)
elif factor == 5:
    if B in L:
        print(2)
    else:
        print(3)
elif factor == 4:
    print(4)
elif factor == 3:
    print(5)
else:
    print(0)
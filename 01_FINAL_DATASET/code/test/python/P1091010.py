# -*- coding:utf-8 -*-
abc = list(map(int,input().split()))
index = abc.index(max(abc))
factor = 0
for tmp in range (0, len(abc)):
    if tmp != index:
        factor += abc[tmp]
    else:
        continue

if abc[index] == factor:
    print("Yes")
else:
    print("No")
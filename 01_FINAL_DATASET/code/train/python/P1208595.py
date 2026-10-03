#! -*- coding:utf-8 -*-
O = str(input())
E = str(input())
O = list(O)
E = list(E)
n = 0
arr = []
for i in range(len(O)*2):
    if n % 2 == 0:
        try:
            arr.append(O.pop(0))
        except:
            pass
    else:
        try:
            arr.append(E.pop(0))
        except:
            pass        
    n += 1
try:
    arr.append(O.pop(0))
except:
    pass

for i in range(len(arr)-1):
    print(arr[i],end = '')

print(arr[-1])

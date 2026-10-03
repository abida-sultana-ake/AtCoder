# coding: utf-8
import sys
n = int(input())
_max = -1
p = -1
for i in range(2,n+1):
    print('?','1',i)
    sys.stdout.flush()
    x = int(input())
    if _max < x:
        _max = x
        p = i
for i in range(1,n+1):
    if i!=p:
        print('?',p,i)
        sys.stdout.flush()
        x = int(input())
        if _max < x:
            _max = x
print('!',_max)
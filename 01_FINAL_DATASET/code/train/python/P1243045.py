# -*- coding:utf-8 -*-
import sys
N = int(input())
a,b = map(int, input().split())
K = int(input())
P = list(map(int, input().split()))
if P.count(a) == 1 or P.count(b) == 1:
    print("NO")
    sys.exit()
else:
    for tmp in list(set(P)):
        if P.count(tmp) >= 2:
            print("NO")
            sys.exit()
        else:
            pass
print("YES")
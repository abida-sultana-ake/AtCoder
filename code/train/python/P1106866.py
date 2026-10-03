# -*- coding:utf-8 -*-
import re
import sys
N, M = map(int,input().split())
A = [ input() for i in range(N) ] 
B = [ input() for i in range(M) ]
for tmp in range(N-M+1):
    for tmp2 in range(N-M+1):
        flag = True
        for tmp3 in range(M):
            for tmp4 in range(M):
                if A[tmp+tmp3][tmp2+tmp4] != B[tmp3][tmp4]:
                    flag = False
        if flag:
            print("Yes")
            sys.exit()
print("No")
    #if A[tmp].find(B[tmp2]):
    #   pattern = re.complie(B[tmp2])
    #   iterator = re.finditer(pattern, A[tmp])
# -*- coding:utf-8 -*-
import sys
N, A, B = map(int, input().split())
for tmp in range(1, N+1):
    if tmp%2 != 0:
        if N >= A:
            N -= A
        else:
            N = 0
        if N == 0:    
            print("Ant")
            sys.exit()
    else:
        if N >= B:
            N -= B
        else:
            N = 0
        if N == 0:    
            print("Bug")
            sys.exit()
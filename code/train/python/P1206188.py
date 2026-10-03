# -*- coding: utf-8 -*-
import numpy as np
n, m = map(int, input().split())
student = np.zeros([n,2])
check_point = np.zeros([m,2])
res = np.ones([n,m])
for i in range(n):
    student[i,0], student[i,1] = map(int, input().split())
for i in range(m):
    check_point[i,0], check_point[i,1] = map(int, input().split())
    res[:,i] = abs(student[:,0]-check_point[i,0])+abs(student[:,1]-check_point[i,1])
for i in range(n):
    print(np.argmin(res[i,:])+1)

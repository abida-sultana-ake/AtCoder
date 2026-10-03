# coding: utf-8
import math
num_N, num_M = map(int, input().split())
l_stu = [list(map(int, input().split())) for __ in range(num_N)]
l_che = [list(map(int, input().split())) for __ in range(num_M)]

for stu in l_stu:
    dis_ind = []
    for index, che in enumerate(l_che):
        dis = math.fabs(che[0] - stu[0]) + math.fabs(che[1] - stu[1])
        dis_ind.append([dis, index + 1])

    dis_ind.sort(key=lambda x: (x[0], x[1]))
    print(dis_ind[0][1])
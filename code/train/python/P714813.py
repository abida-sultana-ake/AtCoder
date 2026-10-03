# -*- coding: utf-8 -*-
import math

obj_num, q_num = map(int, input().split())
obj_list = []
q_list = []

def calc_cone(r,h,per):
    return (r**2)*math.pi*h/3.0*(per**3)

for i in range(obj_num):
    x,r,h = map(int, input().split())
    obj_list.append((x,r,h))

for i in range(q_num):
    a,b = map(int, input().split())
    q_list.append((a,b))

for a,b in q_list:
    result = 0.0
    for x,r,h in obj_list:
        if x > b or x+h < a:
            continue
        top_margin = 0 if x+h < b else x+h-b
        under_margin = 0 if x > a else a-x

        result += calc_cone(r,h,((h-under_margin)/h)) - calc_cone(r,h,(top_margin/h))
    print(result)

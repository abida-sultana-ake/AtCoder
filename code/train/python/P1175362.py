# -*- coding:utf-8 -*-
n,v1,v2,l = map(int,input().split())

def distance(n,v1,v2,l):
    if n==0:
        return l
    l = (l/v1)*v2
    return distance(n-1,v1,v2,l)
output = "%.10f"%(distance(n,v1,v2,l))

print(float(output))

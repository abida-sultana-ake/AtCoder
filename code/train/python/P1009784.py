# -*- coding:utf-8 -*-

l = list(map(int, input().split()))
a = [0]
a.extend(list(map(int, input().split())))

num = 0
f = True
while(f):
    f = False
    for i in range(l[0]):
        if(((a[i] + a[i+1]) > l[1])):
            f = True
            sub = (a[i] + a[i+1]) - l[1]
            a[i+1] -= sub
            num += sub
print(num)

# -*- coding:utf-8 -*-
days = [False]*366
for i in range(366):
    if i%7 == 0:
        days[i] = True
    elif i%7 == 6:
        days[i] = True
n = int(input())

m31 = [1,3,5,7,8,10,12]
m30 = [4,6,9,11]
m29 = [2]
def gen_mdays(m):
    r = 0
    # m月までの日数を返す
    for i in range(1,m):
        if i in m31:
            r += 31
        elif i in m30:
            r += 30
        else:
            r += 29
    return r
def fill_holiday(days,d):
    if d >= 365:
        d = 365
    elif days[d]:
        d = fill_holiday(days,d+1)
    else:
        pass
    return d

for i in range(n):
    m,d = map(int,input().split("/"))
    day = gen_mdays(m)+d-1
    days[fill_holiday(days,day)] = True
count = 0
output = 0
for i in range(len(days)):
    if days[i]:
        count += 1
        output = max(output,count)
    else:
        count = 0
print(output)

#! coding: UTF-8
num = int(input())
#桁数
def digit(x):
    point = 0
    while int(x) > 0:
        x /= 10
        point += 1
    return point
#num=A*Bの時の最小桁数
def Multi(num):
    y = digit(num)
    A = 1
    while A*A <= num:
        if num%A == 0:
            B = num/A
            C = max(digit(A),digit(B))
            if y > C:
                y = C
        A += 1
    print(y)
Multi(num)

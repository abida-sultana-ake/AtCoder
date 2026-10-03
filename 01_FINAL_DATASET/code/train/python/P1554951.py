a=[1,3,5,7,8,10,12]
b=[4,6,9,11]
c=[2]

d=[int(i) for i in input().split()]

def judge(d):
    if (d[0] in a) and (d[1] in a):
        print("Yes")
    elif (d[0] in b) and (d[1] in b):
        print("Yes")
    elif (d[0] in b) and (d[1] in b):
        print("Yes")
    else:
        print("No")

judge(d)
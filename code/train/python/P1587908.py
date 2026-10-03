# -*- coding:utf-8 -*-
lines = 4
row = 4
A = [ list(map(int, input().split())) for _ in range(lines) ]
horizontalFlag, verticalFlag = (True, True)
for x in reversed(range(1,row)): #horizontal search
    for y in reversed(range(lines)):
        if A[y][x] == A[y][x-1]:
            horizontalFlag = False
            break
        else:
            pass
for y in reversed(range(1,lines)):
    for x in reversed(range(row)):
        if A[y][x] == A[y-1][x]:
            verticalFlag = False
            break
        else:
            pass

if horizontalFlag and verticalFlag:
    print("GAMEOVER")
else:
    print("CONTINUE")
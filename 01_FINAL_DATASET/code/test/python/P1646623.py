from math import *
n = int(input())
tim = [0]*289
for _ in range(n):
    ln = input()
    sh = int(ln[0:2])
    sm = int(ln[2:4])
    sidx = int(sh*12+floor(sm/5))
    eh = int(ln[5:7])
    em = int(ln[7:9])
    eidx = int(eh*12+ceil(em/5))


    for i in range(sidx,eidx):
        tim[i] = 1

if tim[0] == 1: print("0000-",end="")
for i in range(1,289):
    if tim[i-1] == 0 and tim[i] == 1:
        print("{:02}{:02}-".format(i//12,i%12*5),end="")
    if tim[i-1] == 1 and tim[i] == 0:
        print("{:02}{:02}".format(i//12,i%12*5))
if tim[288] == 1: print("2400")

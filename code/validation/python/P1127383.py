import math

N = int(input())
A = list()
B = list()
for i in range(0,N):
    x, y = [int(i) for i in input().split()]
    A.append([x, y])
for i in range(0,N):
    x, y = [int(i) for i in input().split()]
    B.append([x, y])


A_xofCG = 0
A_yofCG = 0
B_xofCG = 0
B_yofCG = 0
for i in range(0, N):
    A_xofCG += A[i][0]
    A_yofCG += A[i][1]
    B_xofCG += B[i][0]
    B_yofCG += B[i][1]

A_xofCG /= N
A_yofCG /= N
B_xofCG /= N
B_yofCG /= N

mLofA = math.sqrt((A_xofCG - A[0][0]) ** 2 + (A_yofCG - A[0][1]) ** 2)
mLofB = math.sqrt((B_xofCG - B[0][0]) ** 2 + (B_yofCG - B[0][1]) ** 2)
for i in range(1, N):
    Al = math.sqrt((A_xofCG - A[i][0]) ** 2 + (A_yofCG - A[i][1]) ** 2)
    Bl = math.sqrt((B_xofCG - B[i][0]) ** 2 + (B_yofCG - B[i][1]) ** 2)
    if mLofA < Al:
        mLofA = Al
    if mLofB < Bl:
        mLofB = Bl

print(mLofB / mLofA)

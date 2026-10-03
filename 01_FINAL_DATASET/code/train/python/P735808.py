L,X,Y,S,D = map(int, input().split())

M1 = 0
M2 = 0

if D > S:
    M1 = D-S
    M2 = L-(D-S)
else:
    M1 = D+L-S
    M2 = S-D

time1 = M1/(Y+X)
if Y > X:
    time2 = M2/(Y-X)
    print(min(time1,time2))
else:
    print(time1)

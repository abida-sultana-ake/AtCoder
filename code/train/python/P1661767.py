import math
H , W = map(int,input().split())
S = set()

def half_cut(x,y):
    for i in range(1,x):
        S1 = (x-i)*y
        S2 = math.ceil(y/2)*i
        S3 = math.floor(y/2)*i
        S.add(max(S1,S2,S3)-min(S1,S2,S3))

def three_cut(x,y):
    for i in range(1,x):
        S1 = math.ceil(i/2)*y
        S2 = math.floor(i/2)*y
        S3 = (x-i)*y
        S.add(max(S1,S2,S3)-min(S1,S2,S3))

half_cut(H,W)
half_cut(W,H)
three_cut(H,W)
three_cut(W,H)

print(min(S))
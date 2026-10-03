
R,B = map(int,input().split())
x,y = map(int,input().split())

l = 0
r = min((R,B))+1
while r-l>1:
    m = (r+l)//2
    nR = R-m
    nB = B-m
    if nR//(x-1) + nB//(y-1) >= m:
        l = m
    else:
        r = m
print(l)

import math

H, W, N = map(int, input().split())
count = [0]*10
count[0] = (H-2)*(W-2)
rectmap={}

#print(board)
for i in range(0,N):
    a, b = input().split()
    a = int(a)
    b = int(b)
    ab = (a, b)
    al = max(a-1, 2)
    au = min(a+2, H)
    bl = max(b-1, 2)
    bu = min(b+2, W)

    for j in range(al, au):
        for k in range(bl, bu):
            if (j,k) in rectmap:
                rectmap[(j,k)] +=1
            else:
                rectmap[(j,k)] = 1
#            print(rectmap)
##    for j in range(a-1, a+2):
##        for k in range(b-1, b+2):
##            if j>1 and j<H and k>1 and k<W:
##                rectmap.append([j-1, k-1])
#print(rectmap)
for i in rectmap.values():
    count[i]+=1
    count[0]-=1
for c in count:
    print(c)
#print(H,W,N)
#print(ab)

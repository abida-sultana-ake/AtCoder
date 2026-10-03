import math
H,W = map(int,input().split())

if H%3==0 or W%3==0:
    print(0)
elif H==2 and W==2:
    print(1)
else:

    def cal(x,y):
        return max(x*y,(W-x)*y,(H-y)*W) - min(x*y,(W-x)*y,(H-y)*W)

    x1,x2 = math.floor(W/2),math.ceil(W/2)
    y1,y2 = math.floor((2*H)/3),math.ceil((2*H)/3)

    ans1 = min(cal(x1,y1),cal(x2,y1),cal(x1,y2),cal(x2,y2))

    W,H = H,W
    x1,x2 = math.floor(W/2),math.ceil(W/2)
    y1,y2 = math.floor((2*H)/3),math.ceil((2*H)/3)

    ans2 = min(cal(x1,y1),cal(x2,y1),cal(x1,y2),cal(x2,y2))

    if H ==2 or W == 2:
        print(min(ans1,ans2,max(H,W)))
    else:
        print(min(ans1,ans2,H,W))
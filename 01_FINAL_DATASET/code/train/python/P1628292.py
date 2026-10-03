import math
H,W = map(int,input().split())

if H%3==0 or W%3==0:
    print(0)
elif H==2 and W==2:
    print(1)
else:
    def cal2(h,w):
        x1,x2 = math.floor(w/2),math.ceil(w/2)
        y1,y2 = math.floor((2*h)/3),math.ceil((2*h)/3)
        def cal(x,y):
            return max(x*y,(w-x)*y,(h-y)*w) - min(x*y,(w-x)*y,(h-y)*w)
        return min(cal(x1,y1),cal(x2,y1),cal(x1,y2),cal(x2,y2))

    if H==2 or W ==2:
        print(min(cal2(H,W),cal2(W,H),max(H,W)))
    else:
        print(min(cal2(H,W),cal2(W,H),H,W))
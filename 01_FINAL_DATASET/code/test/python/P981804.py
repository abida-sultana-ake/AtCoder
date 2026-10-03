w,h,n=map(int,input().split())
xmax=w
xmin=ymin=0
ymax=h
for i in range(n):
    x,y,a=map(int,input().split())
    if a==1:
        xmin=max(xmin,x)
    elif a==2:
        xmax=min(xmax,x)
    elif a==3:
        ymin=max(ymin,y)
    else:
        ymax=min(ymax,y)

width=max(0,xmax-xmin)
height=max(0,ymax-ymin)

print(width*height)
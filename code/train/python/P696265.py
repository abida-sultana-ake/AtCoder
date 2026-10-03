x1,y1,r=map(int,raw_input().split())
x2,y2,x3,y3=map(int,raw_input().split())
x11=x1+r
x12=x1-r
y11=y1+r
y12=y1-r
if x2<=x11<=x3 and x2<=x12<=x3:
    if y2<=y11<=y3 and y2<=y12<=y3:
        print('NO')
    else:
        print('YES')
else:
    print('YES')
if abs(x2-x1)**2+abs(y2-y1)**2<=r**2 and abs(x2-x1)**2+abs(y3-y1)**2<=r**2 and abs(x3-x1)**2+abs(y2-y1)**2<=r**2 and abs(x3-x1)**2+abs(y3-y1)**2<=r**2:
    print('NO')
else:
    print('YES')

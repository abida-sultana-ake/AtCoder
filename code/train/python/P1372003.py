a, b, c = map(int, input().split('/'))
if a%400==0 or (a%4==0 and a%100!=0):
    while a % (b*c) != 0:
        if b == 1 or b == 3 or b == 5 or b == 7 or b == 8 or b == 10:
            if c<31:
                c+=1
            else:
                c=1
                b+=1
        elif b == 4 or b == 6 or b == 9 or b == 11:
            if c<30:
                c+=1
            else:
                c=1
                b+=1
        elif b == 2:
            if c<29:
                c+=1
            else:
                c=1
                b+=1
        elif b == 12:
            if c<31:
                c+=1
            else:
                c=1
                b=1
                a+=1
if a%4!=0 or (a%100==0 and a%400!=0):
    while a % (b*c) != 0:
        if b == 1 or b == 3 or b == 5 or b == 7 or b == 8 or b == 10:
            if c<31:
                c+=1
            else:
                c=1
                b+=1
        elif b == 4 or b == 6 or b == 9 or b == 11:
            if c<30:
                c+=1
            else:
                c=1
                b+=1
        elif b == 2:
            if c<28:
                c+=1
            else:
                c=1
                b+=1
        elif b == 12:
            if c<31:
                c+=1
            else:
                c=1
                b=1
                a+=1
a = '{:2d}'.format(a)
b = '{:02d}'.format(b)
c = '{:02d}'.format(c)
x = "{}/{}/{}".format(a, b, c)
print(x)
x=int(raw_input())
if x<=6:
    print(1)
else:
    x-=6
    if x%11>5:
        print(x/11*2+2+1)
    else:
        if x%11==0:
            print(x/11*2+1)
        else:
            print(x/11*2+1+1)
w,a,b = map(int,input().split())
if a+w>=b:
    if a<=b+w:
        print(0)
    elif a>=b+w:
        print(a-b-w)
elif a+w<=b:
    print(b-a-w)

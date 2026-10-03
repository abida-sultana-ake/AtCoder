W,a,b=map(int,input().split())
if b >= a+W:
    print(b-a-W)
elif a>= b+W:
    print(a-b-W)
else:
    print(0)
    
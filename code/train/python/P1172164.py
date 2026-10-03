W, a, b = map(int,input().split())

if b+W<a:
    an = a-b-W
elif b+W>=a and b<=a+W:
    an = 0
elif b>a+W:
    an = b-a-W

print(an)




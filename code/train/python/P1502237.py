a, b, x = map(int, input().split())
if a != 0:
    print( b // x - (a - 1)//x )
else:
    print(b // x + 1)

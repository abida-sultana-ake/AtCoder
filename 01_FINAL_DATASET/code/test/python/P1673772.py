a,b,c = [int(i) for i in input().split()]
if a is b+c or b is a+c or c is a + b:
    print('Yes')
else:
    print('No')
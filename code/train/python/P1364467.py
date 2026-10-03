a = [int(i) for i in input().split()]
if a[0] < a[1] :
    print((a[0]+1) * a[1])
else :
    print(a[0] * (a[1] + 1))
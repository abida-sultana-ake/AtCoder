a = [int(i) for i in input().split()]
if a[1] / a[0] > a[3] / a[2] :
    print ('TAKAHASHI')
elif a[1] / a[0] < a[3] / a[2] :
    print ('AOKI')
else :
    print ('DRAW')
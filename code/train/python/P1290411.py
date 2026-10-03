n, m = map(int, input().split())

a = [0, 0, 0]
if n*2 > m or n*4 < m:
    print("-1 -1 -1")
else:
    x = m - n*3
    a[1] = n
    if x>0:
        a[1] -= x
        a[2] += x
    elif x<0:
        a[1] += x
        a[0] -= x
    print ("%d %d %d" % (a[0], a[1], a[2]))

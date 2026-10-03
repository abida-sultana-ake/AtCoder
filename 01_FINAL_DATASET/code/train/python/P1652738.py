n = int(input())
a_yobi = 0
a = [0, 0, 1]

if n<3:
    print(0)
else:
    for i in range(n-3):
        a_yobi = a[0] + a[1] + a[2]
        del a[0]
        a.append(a_yobi%10007)
    print(a[2])

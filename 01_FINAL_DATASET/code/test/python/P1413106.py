a = int(input())
m = a / 1000
if m < 0.1:
    print("00")
elif m >= 0.1 and m <= 5:
    s = m * 10
    s = int(s)
    ans = "{0:02d}".format(s)
    print(ans)
elif m >= 6 and m <= 30:
    s = m + 50
    s = int(s)
    print(s)
elif m >= 35 and m <= 70:
    s = (m - 30) / 5 + 80
    s = int(s)
    print(s)
elif m >= 70:
    print("89")

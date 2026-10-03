m = int(input())

if 100 > m:
    print("00")
elif 100 <= m and 5000 >= m:
    w = m / 100
    if 1000 > m:
        print("0", end='')
        print(int(w))
    else:
        print(int(w))
elif 6000 <= m and 30000 >= m:
    w = (m / 1000) + 50
    print(int(w))
elif 35000 <= m and 70000 >= m:
    w = (((m/1000)-30)/5)+80
    print(int(w))
else:
    print(89)

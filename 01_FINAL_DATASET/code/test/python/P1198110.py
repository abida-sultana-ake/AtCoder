a = int(input())

if a < 100:
    print("00")
elif 100 <= a <= 5000:
    if a < 1000:
        print("0{0}".format(int(a / 100)))
    else:
        print(int(a / 100))
elif 6000 <= a <= 30000:
    print(int(a / 1000 + 50))
elif 35000 <= a <= 70000:
    print(int((a / 1000 - 30) / 5 + 80))
else:
    print("89")

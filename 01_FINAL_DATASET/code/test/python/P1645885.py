number = int(input())/1000

if number < 0.1:
    print("00")
elif 0.1 <= number <= 5:
    print("{0:02d}".format(int(number*10)))
elif 6 <= number <= 30:
    print(int(number+50))
elif 35 <= number <= 70:
    print(int((number-30)/5+80))
elif number > 70:
    print(89)

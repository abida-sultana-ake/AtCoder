a = int(input())

if a < 100:
    b = 0
elif a <= 5000:
    b = a / 100
elif a <= 30000:
    b = a / 1000 + 50
elif a <= 70000:
    b = (a / 1000 - 30) / 5 + 80
else:
    b = 89
c = "0" + str(round(b))
print(c[-2:])

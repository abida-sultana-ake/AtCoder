x = float(input()) / 1000

if x < 0.1:
    ret = 0
elif 0.1 <= x <= 5:
    ret = int(x * 10)
elif 6 <= x <= 30:
    ret = int(x + 50)
elif 35 <= x <= 70:
    ret = int((x - 30) / 5 + 80)
elif 70 <= x:
    ret = 89

print('{0:02d}'.format(ret))

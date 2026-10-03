m = int(input()) / 1000
 
if m < 0.1:
    ans = 0
elif m >= 0.1 and m <= 5:
    ans = m * 10
elif m >= 6 and m <= 30:
    ans = m + 50
elif m >= 35 and m <= 70:
    ans = (m - 30) / 5 + 80
else:
    ans = 89
 
print("{0:02d}".format(int(ans)))
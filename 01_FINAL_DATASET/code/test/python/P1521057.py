m = int(input())
if m < 100:
    print('00')
elif m <= 5000:
    print(str(m // 100).zfill(2)) 
elif 6000 <= m <= 30000:
   print((m + 50000) // 1000)
elif 35000 <= m <= 70000:
    print(((m - 30000) // 5 + 80000) // 1000)
elif m > 70000:
    print(89)
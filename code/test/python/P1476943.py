m = int(input())

if m < 100:
    print("00")
elif m <= 5000:
    VV = int((m/1000)*10)
    if len(str(VV)) == 1:
        print("0"+str(VV))
    else:
        print(VV)
    
elif m <= 30000:
    VV = int((m/1000) + 50)
    print(VV)
elif m <= 70000:
    VV = int(((m/1000) - 30)/5 + 80)
    print(VV)
else:
    print("89")
w, h = map(float, str(input()).split(" "))

if w / h == 4 / 3.0:
    print("4:3")
elif w / h == 16 / 9.0:
    print("16:9")
else:
    print("")

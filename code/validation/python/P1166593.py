a,b = map(str,input().split())
if a=="H" and b == "H":
    print("H")
elif a=="D" and b == "H":
    print("D")
elif a=="H" and b == "D":
    print("D")
elif a=="D" and b == "D":
    print("H")
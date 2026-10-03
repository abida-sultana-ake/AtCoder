a, b = list(map(str, input().split()))
hd = True if a == "H" else False
if hd: print(b)
else:
    print("H") if b == "D" else print("D")

n = input()
tmp_n = n.split(" ")

a = int(tmp_n[0])
b = int(tmp_n[1])

if a+b < 10:
    print(a+b)
else:
    print("error")

N = list(input())

flag = False
if N[0] == "9":
    flag = True
if N[1] == "9":
    flag = True

if flag:
    print("Yes")
else:
    print("No")
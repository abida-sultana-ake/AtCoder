n = input()
t = 1

for i in range(len(n)):
    if n[i] == "9":
        print("Yes")
        t =0
        break
       
if t: print("No")

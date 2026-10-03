x = list(input())
n = 0

for i in range(len(x)):
    if x[i] !=  "o" and x[i] != "k" and x[i] != "u":
        if x[i] == "c" and i != len(x):
            if x[i+1] != "h":
                n += 1
                break
        elif x[i] != "c" and x[i] != "h":
            n += 1
            break
        elif x[i] == "h" and i != 0:
            if x[i-1] != "c":
                n += 1
                break
        elif x[i] == "h" and i == 0:
            n += 1
            break
if n == 0:
    print("YES")
else:
    print("NO")

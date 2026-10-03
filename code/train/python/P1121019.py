S = input()

T = ["c", "o", "k", "u"]

flag = 0
for x in S:
    if flag == 1:
        if x == "h":
            flag = 0
            continue
        else:
            print("NO")
            break

    if x not in T:
        print("NO")
        break
    else:
        if x == "c":
            flag = 1
else:
    print("YES")
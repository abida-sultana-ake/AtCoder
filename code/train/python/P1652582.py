lstS = list(input())
lstT = list(input())
X = list("atcoder@")
ans = 0

for i in range(len(lstS)):
    if lstS[i] != lstT[i]:
        if lstS[i] == "@":
            if lstT[i] in X:
                ans += 1
        elif lstT[i] == "@":
            if lstS[i] in X:
                ans += 1

    else:
        ans += 1

if ans == len(lstS):
    print("You can win")
else:
    print("You will lose")

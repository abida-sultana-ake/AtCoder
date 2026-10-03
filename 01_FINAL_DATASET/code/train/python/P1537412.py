S = input()
T = input()
judge = 0
for i in range(len(S)):
    if S[i] != T[i]:
        if S[i] == "@":
            if (T[i] != "a") and (T[i] != "t") and (T[i] != "c") and (T[i] != "o") and (T[i] != "d") and (T[i] != "e") and (T[i] != "r"):
                judge = 1
                break
        if T[i] == "@":
            if (S[i] != "a") and (S[i] != "t") and (S[i] != "c") and (S[i] != "o") and (S[i] != "d") and (S[i] != "e") and (S[i] != "r"):
                judge = 1
                break
        if (S[i] != "@") and (T[i] != "@"):
            judge = 1
            break

if judge == 0:
    print("You can win")
if judge == 1:
    print("You will lose")
def isdigit(str):
    return type(str) is int

S = input()
for i in range(len(S)):
    if S[i].isdigit():
        if i == len(S) - 1:
            print(S[-1])
            break
        if S[i+1].isdigit():
            print(S[i] + S[i+1])
            break
        else:
            print(S[i])
            break

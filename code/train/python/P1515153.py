S = input()

word = list(S)

for i in range(len(S)):
    if word[i] == "O":
        word[i] = 0
    elif word[i] == "D":
        word[i] = 0
    elif word[i] == "I":
        word[i] = 1
    elif word[i] == "Z":
        word[i] = 2
    elif word[i] == "S":
        word[i] = 5
    elif word[i] == "B":
        word[i] = 8
ans = "".join(map(str, word))
print(ans)

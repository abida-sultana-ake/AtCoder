S = list(map(str, input().split()))

for i in range(len(S)):
    if S[i] == "Left":
        S[i] = "<"
    elif S[i] == "Right":
        S[i] = ">"
    elif S[i] == "AtCoder":
        S[i] = "A"
for i in range(len(S)-1):
    print(S[i], end=" ")

print(S[len(S)-1])

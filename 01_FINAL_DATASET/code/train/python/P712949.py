S = str(input())

for p in range(len(S)-1):
    if S[p:p+2].isdigit():
        print(S[p:p+2])
        exit(0)

for p in range(len(S)):
    if S[p].isdigit():
        print(S[p])
        exit(0)
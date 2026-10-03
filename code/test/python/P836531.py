S = str(input())

for k in range(len(S)-1):
    if S[k] == S[k+1]:
        print(k+1,k+2)
        exit()

for k in range(len(S)-2):
    if S[k] == S[k+2]:
        print(k+1,k+3)
        exit()

print(-1,-1)
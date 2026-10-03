S = input().strip()
cnt = 0
for i in range(len(S)):
    if i == len(S)-1:
        print(cnt)
        break
    if S[i] != S[i+1]:
        cnt += 1
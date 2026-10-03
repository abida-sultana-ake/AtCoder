S = list(input())
cnt = 0
key = S[0]
for i in range(1,len(S)):
    if key != S[i]:
        key = S[i]
        cnt += 1
print(cnt)
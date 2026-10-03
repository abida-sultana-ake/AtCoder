S = input()

for i in range(1, len(S)):
    if len(S[:-i]) % 2 == 1:
        continue
    if S[:int(len(S[:-i])/2)] == S[int(len(S[:-i])/2):-i]:
        ans = len(S[:int(len(S[:-i]))])
        break
print(ans)
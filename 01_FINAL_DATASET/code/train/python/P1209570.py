n = int(input())
S = []
for i in range(n):
    S.append(list(input()))

match = []
for i in range(n):
    if i == 0: match = S[i][:]
    else:
        match_tmp = []
        for j in match:
            for k in range(len(S[i])):
                if j == S[i][k]:
                    match_tmp.append(S[i][k])
                    S[i][k] = "out"
                    break
        match = match_tmp[:]

print("".join(sorted(match)))

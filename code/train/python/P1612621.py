S = input()
S_r = S[::-1]
count = 0
not_match = 0
N = len(S)
if N == 1:
    print(0)
else:
    for i in range(N//2):
        if S[i] != S_r[i]:
            not_match += 1
    if not_match == 1:
        count = N * 25 - 2
    elif not_match > 1:
        count = N * 25
    else:
        if N % 2:
            count = N * 25 - 25
        else:
            count = N * 25


    print(count)
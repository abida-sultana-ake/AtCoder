import sys
S = input()
T = input()
wild = '@atcoder'
for i in range(len(S)):
    if S[i] == T[i] or (S[i] == '@' and T[i] in wild) or (T[i] == '@' and S[i] in wild):
        continue
    else:
        print('You will lose')
        sys.exit()
print('You can win')